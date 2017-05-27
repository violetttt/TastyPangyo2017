package tp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import tp.service.RestaurantImageService;
import tp.service.impl.RestaurantImageServiceImpl;
import tp.service.impl.RestaurantServiceImpl;
import tp.vo.Restaurant;

public class InsertRestaurantServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ServletContext ctx = getServletContext(); // 이미지를 저장할 경로
		RestaurantImageService ris = RestaurantImageServiceImpl.getInstance();	// 레스토랑 이미지 서비스 객체 생성
		RestaurantServiceImpl service = RestaurantServiceImpl.getInstance();	// 레스토랑 서비스 객체 생성
		
		
		// 1.요청파라미터 조회
		
		HttpSession session = req.getSession();
		
		
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory(1024*1024, new File(ctx.getInitParameter("tempdir"))));
		
		
		Restaurant vo = new Restaurant();	// 저장할 vo 소환
		List<String> imageName = new ArrayList<>(); // 업로드된 파일명 저장할 List변수
		
		try{
			//	요청 파라미터 조회
			
			List<FileItem> list = upload.parseRequest(req); // 첫번째 for문에서 돌릴 list

	for(FileItem item : list){
			
		String reqName = item.getFieldName(); // 요청파라미터의 이름 조회
			
			if(item.isFormField()){
		
				String reqValue = item.getString("UTF-8");
			//  restaurant vo 초기파라미터 값 지정하기
							if(reqName.equals("resName")){
								vo.setRestaurantName(reqValue);

							}else if(reqName.equals("resTelNum")){
								vo.setRestaurantTelNum(reqValue);

							}else if(reqName.equals("location")){
								vo.setLocation(reqValue);

							}else if(reqName.equals("foodCategory")){
								vo.setFoodCategory(reqValue);

							}else if(reqName.equals("menu")){
								vo.setMenu(reqValue);
								
							}else if(reqName.equals("introduction")){
								vo.setIntroduction(reqValue);
								
								service.addRestaurant(vo);	// 맛집 테이블에 저장
								session.setAttribute("insertRes", "등록이 완료 되었습니다.");
								session.setAttribute("insertRestaurant",service.selectRestaurantByID(vo.getRestaurantId()));
							}
		
			}else{
				
			String fileName = item.getName();
			fileName = UUID.randomUUID().toString(); // 중복되지않는 문자열을 만들어서 파일명으로 쓴다
			
			// upload된 파일이 있는지 체크. getSize() : upload된 파일의 크기를 byte로 리턴
			if(item.getSize() != 0){
				// 임시경로의 파일을 최종경로로 이동 
				item.write(new File(ctx.getRealPath("/up_images"), fileName)); // imageDir로 fileName 파일을 복사
				// 임시경로의 파일을 삭제
				item.delete();
				imageName.add(fileName);
				
				vo.setImage(fileName);
				ris.insertRestaurantImage(vo);
			}
			}	// 큰 if else 종료
	}	// for문 종료
	

				ris.selectRestaurantImageById(vo.getRestaurantId()); // 위에서 생성된 레스토랑 테이블에서 레스토랑id 번호를 받아오기 위한 작업
				
				vo.setImages(new ArrayList(ris.selectRestaurantImageById(vo.getRestaurantId()))); // 레스토랑 id로 테이블에서 이미지를 호출해 vo에 넣는 작업
				
				req.setAttribute("result", vo.getImages()); // vo에 넣은 이미지들을 속성에 넣어 jsp에 보낸다
				
				session.setAttribute("resId", vo.getRestaurantId());	// 이미지들을 삭제하기 위해 레스토랑 id도 보내준다

			req.getRequestDispatcher("/restaurant/regist_success.jsp").forward(req, resp);
			
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e); // 예외처리를 톰캣에게 맡김. fileuploadException를 sevletException에 넣어서 던짐
		}
	
		}
}

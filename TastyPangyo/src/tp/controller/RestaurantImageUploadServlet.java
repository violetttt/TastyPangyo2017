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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import tp.service.RestaurantImageService;
import tp.service.impl.RestaurantImageServiceImpl;
import tp.vo.Restaurant;

public class RestaurantImageUploadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
	
		ServletContext ctx = getServletContext(); // 이미지를 저장할 경로
		RestaurantImageService ris = RestaurantImageServiceImpl.getInstance();
		
		// ServletFileUpdoad 객체 생성 - DiskFileItemFactory 객체를 전달.
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory(1024*1024, new File(ctx.getInitParameter("tempdir"))));
		
		Restaurant vo = new Restaurant(4, "들어올일름");	// 저장할 vo 소환
		List<String> imageName = new ArrayList<>(); // 업로드된 파일명 저장할 List변수
		
		try{
			//	요청 파라미터 조회
			List<FileItem> list = upload.parseRequest(request); // fileuploadException
			
			for(FileItem item : list){
				String reqName = item.getFieldName(); // 요청파라미터의 이름 조회
				
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
				} // end of if
			}	// end of for

				ris.selectRestaurantImageById(4);
				
				vo.setImages(new ArrayList(ris.selectRestaurantImageById(4)));
				
				request.setAttribute("result", vo.getImages()); // ===> Model 호출해서 Business Logic 처리
				
				request.setAttribute("restaurtid", vo.getRestaurantId());
			
			// 응답 처리
			request.getRequestDispatcher("/restaurant/regist_success.jsp").forward(request, respose);
			
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e); // 예외처리를 톰캣에게 맡김. fileuploadException를 sevletException에 넣어서 던짐
		}

	} // end of doPost
}	// end of main


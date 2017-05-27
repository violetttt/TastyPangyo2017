package tp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.RestaurantImageService;
import tp.service.impl.RestaurantImageServiceImpl;
import tp.vo.Restaurant;

public class DeleteRestaurantImage extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {

		RestaurantImageService ris = RestaurantImageServiceImpl.getInstance();
		HttpSession session = request.getSession();
		
		String imagePath = request.getParameter("name");	// 이미지 이름 하나당 받아올 변수
		int restId = (int)session.getAttribute("resId");	// 레스토랑 id를 받아올 변수
		
		Restaurant vo = new Restaurant(restId, "들어올일름");	// 저장할 vo 소환
		
		
		if(imagePath==null){
		ris.deleteRestaurantImage(restId);	// 전체 삭제
		}
		else{	
		ris.deleteRestaurantImageByFile(imagePath);	// 이미지 하나 삭제
		}
		
		vo.setImages(new ArrayList(ris.selectRestaurantImageById(restId)));	// 삭제한 이미지를 제외해서 뿌려주기 위한 세팅 작업
		
		request.setAttribute("result", vo.getImages()); // ===> Model 호출해서 Business Logic 처리
		
		request.getRequestDispatcher("/restaurant/regist_success.jsp").forward(request, respose);
	}

}

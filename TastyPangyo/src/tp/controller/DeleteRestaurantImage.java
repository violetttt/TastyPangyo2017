package tp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.service.RestaurantImageService;
import tp.service.impl.RestaurantImageServiceImpl;
import tp.vo.Restaurant;

public class DeleteRestaurantImage extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
		
		RestaurantImageService ris = RestaurantImageServiceImpl.getInstance();
		
		
		
		String imagePath = request.getParameter("name");
		String restId = request.getParameter("restId");
		
		System.out.println("restId ="  + restId);
		
		int id = Integer.parseInt(restId);	
		System.out.println(id);
		
		request.setAttribute("restId", id);
		
		Restaurant vo = new Restaurant();	// 저장할 vo 소환
		
		if(imagePath==null){	// 전체 삭제
		ris.deleteRestaurantImage(id);
		System.out.println("무엇이 돌아가는지 확인: imagePath==null");
		}
		else{
			
		ris.deleteRestaurantImageByFile(imagePath);
		System.out.println("무엇이 돌아가는지 확인: else");
		}
		
		vo.setImages(new ArrayList(ris.selectRestaurantImageById(id)));
		
		request.setAttribute("result", vo.getImages()); // ===> Model 호출해서 Business Logic 처리
		
		request.setAttribute("restId", restId);
		
		request.getRequestDispatcher("/restaurant/regist_success.jsp").forward(request, respose);
	}

}

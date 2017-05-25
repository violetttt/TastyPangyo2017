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
		
		
		Restaurant vo = new Restaurant(4, "들어올일름");	// 저장할 vo 소환
		
		if(imagePath==null){
		ris.deleteRestaurantImage(4);
		}
		else{
			
		ris.deleteRestaurantImageByFile(imagePath);
		}
		
		vo.setImages(new ArrayList(ris.selectRestaurantImageById(4)));
		
		request.setAttribute("result", vo.getImages()); // ===> Model 호출해서 Business Logic 처리
		
		request.getRequestDispatcher("/restaurantImage/insertimage_result.jsp").forward(request, respose);
	}

}

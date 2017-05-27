package tp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.exception.NotFoundRestaurantIdException;
import tp.service.RestaurantImageService;
import tp.service.impl.RestaurantImageServiceImpl;
import tp.service.impl.RestaurantServiceImpl;
import tp.vo.Restaurant;

public class UpdateRestaurantServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ServletContext ctx = getServletContext();
		RestaurantImageService 	imageService = RestaurantImageServiceImpl.getInstance(); //레스토랑 이미지 서비스 객체 생성
		RestaurantServiceImpl 	resService 	 = RestaurantServiceImpl.getInstance();
		
				
	}
}

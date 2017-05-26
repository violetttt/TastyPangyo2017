package tp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.exception.NotFoundRestaurantIdException;
import tp.service.impl.RestaurantServiceImpl;
import tp.vo.Restaurant;

public class SelectRestaurantById extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 요청파라미터 조회
		int resId = Integer.parseInt(req.getParameter("restaurantId"));
		
		
		//2. 처리
		
		RestaurantServiceImpl service = RestaurantServiceImpl.getInstance();
		try{
			Restaurant res = service.selectRestaurantByID(resId);
			req.setAttribute("selectRes", res);
			req.setAttribute("errorMessage", "등록 성공");
			req.setAttribute("image", res.getImages());
		}catch(NotFoundRestaurantIdException e){
			req.setAttribute("errorMessage", e.getMessage());
		}
		
		
		//응답
		req.getRequestDispatcher("/restaurant/restaurant_detail_information.jsp").forward(req, resp);
	}
}

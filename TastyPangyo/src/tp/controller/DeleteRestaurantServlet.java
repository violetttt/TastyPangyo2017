package tp.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.exception.NotFoundRestaurantIdException;
import tp.service.impl.RestaurantServiceImpl;

public class DeleteRestaurantServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//1. 요청파라미터 조회
		
		Enumeration<String> s = req.getParameterNames();
		int paramName = Integer.parseInt(s.nextElement());
		
	//2. 처리
		RestaurantServiceImpl service = RestaurantServiceImpl.getInstance();		
		String deleteRes = null;
		HttpSession session = req.getSession();
		
		
			try {
				service.deleteRestaurant(paramName);
				deleteRes= "등록성공";
				session.setAttribute("deleteRes", deleteRes);
				session.setAttribute("resList", service.selectAllRestaurant());
			} catch (NotFoundRestaurantIdException e) {
				deleteRes="등록실패";
				session.setAttribute("deleteRes", deleteRes);
			}
				
	
		
	//3.응답
		resp.sendRedirect("restaurant/res_result.jsp");
	}	
}

package tp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.impl.RestaurantServiceImpl;
import tp.vo.Restaurant;

public class InsertRestaurantServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//1.요청파라미터 조회
		req.setCharacterEncoding("utf-8");
		int resIdSeq = 1; 		//임의로 넣어줄 맛집 id번호
		int hits = 1;	  		//임의로 넣어줄 조회수
		
		
		String name = req.getParameter("resName");
		String resTelNum = req.getParameter("resTelNum");
		String location = req.getParameter("location");
		String foodCategory=req.getParameter("foodCategory");
		String menu = req.getParameter("menu");
		String introduction = req.getParameter("introduction");
	
		
	//2.처리
		
		Restaurant res = 
			new Restaurant(resIdSeq, foodCategory, location, name, hits, resTelNum, introduction, menu);
			//요청파라미터로 받은 restaurant 객체
		
		RestaurantServiceImpl service = RestaurantServiceImpl.getInstance();
		String result = null;
		
		try {
			service.addRestaurant(res);			
		} catch (SQLException e) {
			result = "등록에 실패하였습니다.";
			req.setAttribute("result", result);
		}
		result = "등록 성공";
		req.setAttribute("result", result);
		
	//3.응답
		req.getRequestDispatcher("/restaurant/regist_success.jsp").forward(req, resp);		
		
	}
	

}

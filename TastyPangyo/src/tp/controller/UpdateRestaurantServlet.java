package tp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.exception.NotFoundRestaurantIdException;
import tp.service.impl.RestaurantServiceImpl;
import tp.vo.Restaurant;

public class UpdateRestaurantServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//1. 요청 파라미터 조회
		int hits = 1; 								 			// 임의로 들어간 조회수
		int resId = Integer.parseInt(req.getParameter("resId"));// id가 없으면 "올바른 id를 입력하세요" 메세지 출력
	
		String resName = req.getParameter("resName");
		String resTelNum = req.getParameter("resTelNum");
		String location = req.getParameter("location");
		String foodCategory=req.getParameter("foodCategory");
		String menu = req.getParameter("menu");
		String introduction = req.getParameter("introduction");
		
		//2. 처리

		HttpSession session = req.getSession();		
		RestaurantServiceImpl service = RestaurantServiceImpl.getInstance();
									//결과를 보여줄 변수
		

		try {
			if(resName.isEmpty()||foodCategory.isEmpty()||location.isEmpty()
					||resName.isEmpty()||resTelNum.isEmpty()||location.isEmpty()||foodCategory.isEmpty()||menu.isEmpty()){
			session.setAttribute("updateRes", "값을 제대로 입력해주세요");
			req.getRequestDispatcher("/restaurant/update_restaurant_form.jsp").forward(req, resp);
			}else{
			service.modRestaurant(new Restaurant(resId, foodCategory, location, resName, hits, resTelNum, introduction, menu));
			session.setAttribute("resList", service.selectAllRestaurant());
			resp.sendRedirect("restaurant/res_result.jsp");
			}
		} catch (NotFoundRestaurantIdException e) {
			session.setAttribute("updateRes", e.getMessage());
		}	
			
		//3. 응답
			
		
				
	}
}

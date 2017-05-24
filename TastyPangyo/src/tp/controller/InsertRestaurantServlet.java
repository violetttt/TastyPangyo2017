package tp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.exception.NotInputDataException;
import tp.service.impl.RestaurantServiceImpl;
import tp.vo.Restaurant;

public class InsertRestaurantServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.요청파라미터 조회
		req.setCharacterEncoding("utf-8");

		String name = req.getParameter("resName");
		String resTelNum = req.getParameter("resTelNum");
		String location = req.getParameter("location");
		String foodCategory = req.getParameter("foodCategory");
		String menu = req.getParameter("menu");
		String introduction = req.getParameter("introduction");

		// 2.처리
		RestaurantServiceImpl service = RestaurantServiceImpl.getInstance();

		if (name.isEmpty() || resTelNum.isEmpty() || location.isEmpty() || foodCategory.isEmpty() || menu.isEmpty()
				|| introduction.isEmpty()) {
			req.setAttribute("insertRes", "값을 입력해 주세요");
		} else {
			Restaurant res = new Restaurant(0, foodCategory, location, name, 0, resTelNum, introduction, menu);
			service.addRestaurant(res);
			req.setAttribute("insertRes", "등록이 완료되었습니다");
		}
		req.getRequestDispatcher("/restaurant/regist_success.jsp").forward(req, resp);
	}

}

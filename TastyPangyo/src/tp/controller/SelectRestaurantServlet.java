package tp.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.exception.LoginFailException;
import tp.service.impl.RestaurantServiceImpl;
import tp.vo.Member;

public class SelectRestaurantServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 요청 파라미터 조회
		HttpSession session = req.getSession();
		Enumeration<String> s = req.getParameterNames();
		String paramName = s.nextElement();

		String resSelectKey = req.getParameter(paramName);
		req.setAttribute("resSelectKey", resSelectKey);

		System.out.println(paramName);

		// 처리
		RestaurantServiceImpl service = RestaurantServiceImpl.getInstance();
		Member member = (Member) session.getAttribute("login");
		System.out.println("로그 : "+ member);
			
				switch (paramName) {
				case "allRes"
				:	if (member==null || !member.getMemberId().equals("admin")) {
						session.setAttribute("resList", service.selectAllRestaurant());
						req.getRequestDispatcher("/restaurant/user_select_result.jsp").forward(req, resp);
					} 
						session.setAttribute("resList", service.selectAllRestaurant());
						req.getRequestDispatcher("/restaurant/res_result.jsp").forward(req, resp);
		
					break;
		
				case "location":
					if (!member.getMemberId().equals("admin")) {
						session.setAttribute("resList", service.selectRestaurantByLocation(resSelectKey));
						req.getRequestDispatcher("/restaurant/user_select_result.jsp").forward(req, resp);
					} else {
						session.setAttribute("resList", service.selectRestaurantByLocation(resSelectKey));
						req.getRequestDispatcher("/restaurant/res_result.jsp").forward(req, resp);
					}
					break;
		
				case "resName":
					if (!member.getMemberId().equals("admin")) {
						session.setAttribute("resList", service.selectRestaurantByName(resSelectKey));
						req.getRequestDispatcher("/restaurant/user_select_result.jsp").forward(req, resp);
					} else {
						session.setAttribute("resList", service.selectRestaurantByName(resSelectKey));
						req.getRequestDispatcher("/restaurant/res_result.jsp").forward(req, resp);
					}
					break;
		
				case "foodCategory":
					if (!member.getMemberId().equals("admin")) {
						session.setAttribute("resList", service.selectRestaurantBySort(resSelectKey));
						req.getRequestDispatcher("/restaurant/user_select_result.jsp");
					} else {
						session.setAttribute("resList", service.selectRestaurantBySort(resSelectKey));
						req.getRequestDispatcher("/restaurant/res_result.jsp").forward(req, resp);
					}
				}
			
	}
}

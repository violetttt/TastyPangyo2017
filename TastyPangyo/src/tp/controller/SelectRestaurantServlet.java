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
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doPost(request, response);
		}
	
	@Override
	
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 요청 파라미터 조회
		
		HttpSession session = req.getSession();
		Enumeration<String> s = req.getParameterNames();		// 파라미터의 이름들을 받을 컬렉션
		String paramName = s.nextElement();						// 요소들 중, 다음 파라미터 이름이 있다면 그 값을 넣는다.

		String resSelectKey = req.getParameter(paramName);		// 파라미터 name값으로 가져온  value를 조회값으로 사용한다.
		req.setAttribute("resSelectKey", resSelectKey);			// ex) 검색된 값


		// 처리
		RestaurantServiceImpl service = RestaurantServiceImpl.getInstance();
		Member member = (Member) session.getAttribute("login");
		
				switch (paramName) {
				case "allRes"
				:	if (member==null || !member.getMemberId().equals("admin")) {    // 비회원 또는 일반회원이면 조회만 가능.
						session.setAttribute("resList", service.selectAllRestaurant());
						req.getRequestDispatcher("/restaurant/user_select_result.jsp").forward(req, resp);
					} 
						session.setAttribute("resList", service.selectAllRestaurant());
						req.getRequestDispatcher("/restaurant/manager_select_result.jsp").forward(req, resp);
						break;
		
				case "location":
					if (member==null || !member.getMemberId().equals("admin")) {
						session.setAttribute("resList", service.selectRestaurantByLocation(resSelectKey));
						req.getRequestDispatcher("/restaurant/user_select_result.jsp").forward(req, resp);
					}
						session.setAttribute("resList", service.selectRestaurantByLocation(resSelectKey));
						req.getRequestDispatcher("/restaurant/manager_select_result.jsp").forward(req, resp);
						break;
		
				case "resName":
					if (member==null || !member.getMemberId().equals("admin")) {
						session.setAttribute("resList", service.selectRestaurantByName(resSelectKey));
						req.getRequestDispatcher("/restaurant/user_select_result.jsp").forward(req, resp);
					}
						session.setAttribute("resList", service.selectRestaurantByName(resSelectKey));
						req.getRequestDispatcher("/restaurant/manager_select_result.jsp").forward(req, resp);
						break;
		
				case "foodCategory":
					if (member==null || !member.getMemberId().equals("admin")) {
						session.setAttribute("resList", service.selectRestaurantBySort(resSelectKey));
						req.getRequestDispatcher("/restaurant/user_select_result.jsp");
					} 
						session.setAttribute("resList", service.selectRestaurantBySort(resSelectKey));
						req.getRequestDispatcher("/restaurant/manager_select_result.jsp").forward(req, resp);
						break;
					
				}
			
	}
}

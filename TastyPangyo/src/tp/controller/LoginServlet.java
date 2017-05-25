package tp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.exception.LoginFailException;
import tp.exception.MemberNotFoundException;
import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		// 1. 요청파라미터 조회
		String id = req.getParameter("id");
		
		// 2. 처리- Model 호출
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
		try {
			session.setAttribute("login", service.login(id));
		} catch (LoginFailException e) {
			session.setAttribute("login", "비밀번호가 일치하지 않습니다");
			
		} catch (MemberNotFoundException e) {
			session.setAttribute("login", "아이디가 존재하지 않습니다");
		}
		
/*				try {
					name = service.login(id);
				} catch (LoginFailException e) {
					name = e.getMessage();
				} catch (MemberNotFoundException e) {
					name = e.getMessage();
				}
				
				session.setAttribute("login", name);
				session.setAttribute("fail", name);*/

		
		// 3. 응답 - View 호출
		req.getRequestDispatcher("/jsp/intro.jsp").forward(req, resp);
	}

}

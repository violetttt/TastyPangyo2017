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
		String pw = req.getParameter("pw");
		
		
		// 2. 처리- Model 호출
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		try {
			session.setAttribute("login", service.login(id,pw));
			Member m =  service.login(id,pw);
			m.setVisitDate(new Date());
			service.updateMember(m);
		} catch (LoginFailException e) {
			session.setAttribute("loginfail", e.getMessage());
			
		} catch (MemberNotFoundException e) {
			session.setAttribute("loginfail", e.getMessage());
		}
		session.setAttribute("id", id);
		
		// 3. 응답 - View 호출
		req.getRequestDispatcher("/jsp/intro.jsp").forward(req, resp);
	}

}

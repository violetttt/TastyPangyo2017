package tp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.exception.MemberNotFoundException;
import tp.service.impl.MemberServiceImpl;

public class DeleteMemberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		// 1. 요청파라미터 조회
		String pw = req.getParameter("pw");
		
		
		// 2. 처리
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
		service.deleteMember(pw);
		session.invalidate();
		
		
		// 3. 응답
		req.getRequestDispatcher("/jsp/intro.jsp").forward(req, resp);
		
	}

	
}

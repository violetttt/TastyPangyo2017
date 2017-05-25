package tp.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class UpdateMemberServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		// 1. 조회
		String newName = req.getParameter("rename");
		String newPw = req.getParameter("repw");

		
		// 2. 처리
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		Member m = new Member((String)session.getAttribute("id"), newPw, newName, new Date());
		
		service.updateMember(m);
		session.setAttribute("login", m);
		
		
		// 3. 응답
		//req.getRequestDispatcher("/member/update_result.jsp").forward(req, resp);
		resp.sendRedirect("member/update_result.jsp");
	}

	
}

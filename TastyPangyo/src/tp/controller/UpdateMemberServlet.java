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
		String rePw = req.getParameter("repw2");
		
		// 2. 처리
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		Member om = service.selectMemberById((String)session.getAttribute("id"));
		
		if(newPw.equals(rePw)){
		Member m = new Member(om.getMemberId(), newPw, newName, om.getVisitDate());
		
		service.updateMember(m);
		session.setAttribute("login", m);
		resp.sendRedirect("member/update_result.jsp");
		}else{
			System.out.println("이걸로 넘어오는지 봅시다");
			req.setAttribute("miss", "틀림");
			req.getRequestDispatcher("member/update.jsp").forward(req, resp);
		}
		
		// 3. 응답
		//req.getRequestDispatcher("/member/update_result.jsp").forward(req, resp);
	}

	
}

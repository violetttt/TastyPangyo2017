package tp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class DeleteMemberServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		// 1. 요청파라미터 조회
		String pw = req.getParameter("pw");
		String id = req.getParameter("id");
		
		// 2. 처리
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		if(pw.equals(service.selectMemberById(id).getMemberPw())){
			service.deleteMember(pw);
			session.invalidate();
			// 3. 응답
			req.getRequestDispatcher("/jsp/intro.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("/member/delete_falsePw.jsp").forward(req, resp);
		}
		
		
		
	}

	
}

package tp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class SelectMemberByIdServlet   extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.조회
		String id = req.getParameter("id");
		
		// 2.처리
		 
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		Member member = service.selectMemberById(id);
		req.setAttribute("memberById", member);
		// 3.응답
		req.getRequestDispatcher("/member/selectById_result.jsp").forward(req, resp);
	}
}

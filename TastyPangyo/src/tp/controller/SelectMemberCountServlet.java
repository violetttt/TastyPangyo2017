package tp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.service.impl.MemberServiceImpl;

public class SelectMemberCountServlet   extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.조회
		
		// 2.처리
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		int cnt = service.selectMemberCount();
		req.setAttribute("memberCount", cnt);
		
		// 3.응답
		req.getRequestDispatcher("/member/count.jsp").forward(req, resp);
	}
}

package tp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class SelectAllMemberServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.조회
		
		
		// 2.처리
		List<Member> list = null;
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
		list = service.selectAllMember();
	
		req.setAttribute("allmember", list);
		// 3.응답
		req.getRequestDispatcher("/member/allmember.jsp").forward(req, resp);
	}
}

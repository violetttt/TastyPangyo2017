package tp.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class InsertMemberServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
		// 1. 요청파라미터 조회
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		// 2. 처리 - Model호출
		Member m = new Member(id, pw, name, new Date());
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
/*		String result = service.insertMember(m);
		req.setAttribute("result", result);*/
		// 3. 응답 - View 호출
		req.getRequestDispatcher("/jsp/join_success.jsp").forward(req, resp);
	}

}

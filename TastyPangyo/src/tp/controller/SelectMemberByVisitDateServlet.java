package tp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class SelectMemberByVisitDateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		// 1.조회
		String visitDate = req.getParameter("visitDate");
		
		
		
		// 2.처리
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
		Date date = null;
		List<Member> list = null;
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = transFormat.parse(visitDate);
		} catch (ParseException e) {
			
		}
		list = service.selectMemberByVisitDate(date);
		req.setAttribute("memList", list);
		session.setAttribute("date", visitDate);
		
		// 3.응답
		req.getRequestDispatcher("/member/selectByVisitDate_result.jsp").forward(req, resp);
	}
}

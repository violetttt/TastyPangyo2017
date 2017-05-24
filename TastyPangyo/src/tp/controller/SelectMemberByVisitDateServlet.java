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

import tp.service.impl.MemberServiceImpl;
import tp.vo.Member;

public class SelectMemberByVisitDateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.조회
		String visitDate = req.getParameter("visitDate");
		Date date = null;
		List<Member> list = null;
		
		String[] yymmdd = visitDate.split("-");
		String yy = yymmdd[0];
		String mm = yymmdd[1];
		String dd = yymmdd[2];
		int y = Integer.parseInt(yy);
		int m = Integer.parseInt(mm);
		int d = Integer.parseInt(dd);
		
		date = new Date(y,m,d);
	 
		
		// 2.처리
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		list = service.selectMemberByVisitDate(date);
		req.setAttribute("memList", list);
		
		
		// 3.응답
		req.getRequestDispatcher("/member/selectByVisitDate_result.jsp").forward(req, resp);
	}
}

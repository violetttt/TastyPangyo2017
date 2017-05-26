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
		System.out.println(visitDate);
		Date date = null;
		List<Member> list = null;
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = transFormat.parse(visitDate);
		} catch (ParseException e) {
			
		}
		
		
/*		String[] yymmdd = visitDate.split("-", 3);
		for(String d : yymmdd){
			req.setAttribute("d", d);
		}
		String yy = yymmdd[0];
		String mm = yymmdd[1];
		String dd = yymmdd[2];
		
		int y = Integer.parseInt(yy);
		int m = Integer.parseInt(mm);
		int d = Integer.parseInt(dd);
		
		//date = new Date(y,m,d);
		
		req.setAttribute("yy", yy);
		req.setAttribute("mm", mm);
		req.setAttribute("dd", dd);*/
		
		
		// 2.처리
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		list = service.selectMemberByVisitDate(date);
		req.setAttribute("memList", list);
		req.setAttribute("date", visitDate);
		
		// 3.응답
		req.getRequestDispatcher("/member/selectByVisitDate_result.jsp").forward(req, resp);
	}
}

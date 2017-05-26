package tp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.impl.MemberServiceImpl;

public class DeleteByVisitDateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		// 1. 요청파라미터 조회
		String date = req.getParameter("date");  // 2017-05-01
		
		
		// 2. 처리
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		Date d = null;
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d = transFormat.parse(date);
			service.deleteMemberByVisitDate(d);
		} catch (ParseException e) {
			
		}
		
		
		
		// 3. 응답
		req.getRequestDispatcher("/member/delete_result.jsp").forward(req, resp);
		
	}

	
}

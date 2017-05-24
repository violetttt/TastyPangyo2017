package tp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.service.impl.MemberServiceImpl;

public class SelectMemberServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		// 1. 요청 파라미터 조회
		Enumeration<String> e = req.getParameterNames();
		String select = e.nextElement();
		
		String id = req.getParameter("id");
		String keyword = req.getParameter(select);
		
		//Date vDate = new SimpleDateFormat("yyyy-MM-dd").parse(visitDate);
		int year = Integer.parseInt(req.getParameter("year"))-1900;
		int month = Integer.parseInt(req.getParameter("month"))-1;
		int day = Integer.parseInt(req.getParameter("day"));
		
		Date vDate = new Date(year, month, day);
		keyword = new SimpleDateFormat("yyyy-MM-dd").format(vDate);
		
		// 2. 처리 - Model호출
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		switch(select){
		case "allMember" :
			try {
				req.setAttribute("selectMem", service.selectAllMember());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "memberCount" :
			try {
				req.setAttribute("selectMem", service.selectMemberCount());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "byId" :
			try {
				req.setAttribute("selectMem", service.selectMemberById(id));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "byVisitDate" :
			try {
				req.setAttribute("selectMem", service.selectMemberByVisitDate(vDate));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		// 3. 응답 - View 호출
		req.getRequestDispatcher("").forward(req, resp);
	}

	
}

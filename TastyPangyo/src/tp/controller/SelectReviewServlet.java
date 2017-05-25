package tp.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.service.impl.ReviewManagementServiceImpl;

/**
 * 리뷰 조회 서블릿
 * @author KOSTA
 *
 */
public class SelectReviewServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 1. 요청 파라미터 조회

		Enumeration<String> s = req.getParameterNames();
		String param = s.nextElement();

		
		System.out.println(param);
		
		String selectKeyword = req.getParameter(param);
		req.setAttribute("selectKeyword", selectKeyword);
		System.out.println(selectKeyword);
		// 비지니스로직처리
		ReviewManagementServiceImpl rms = ReviewManagementServiceImpl.getInstance();
		req.setAttribute("reviews", rms.selectReviewByTitle(param));
		switch(param){
			case "allReviews" :
				req.setAttribute("reviews", rms.selectAllReview(selectKeyword));
			case "title" :
				req.setAttribute("reviews", rms.selectReviewByTitle(selectKeyword));
				break;
			case "comments" :
				req.setAttribute("reviews", rms.selectReviewByComments(selectKeyword));
				break;
			case "memberId" :
				req.setAttribute("reviews", rms.selectReviewByComments(selectKeyword));
				break;
			case "reviewNo" :
				req.setAttribute("reviews", rms.selectReviewByNo(Integer.parseInt(selectKeyword)));
				break;
			case "year" :
				int year = Integer.parseInt(req.getParameter("year"))-1900;
				int month = Integer.parseInt(req.getParameter("month"))-1;
				int day = Integer.parseInt(req.getParameter("day"));
				
				Date registeredDate = new Date(year, month, day);
				selectKeyword = new SimpleDateFormat("yyyy-MM-dd").format(registeredDate);
				System.out.println(registeredDate);
				req.setAttribute("reviews", rms.selectReviewByRegisteredDate(registeredDate));
		}
		
		
		// 3. 요청디스패치
		req.getRequestDispatcher("/review/list.jsp").forward(req, resp);
	
	}
	

}

package tp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.service.impl.ReviewServiceImpl;

/**
 * 리뷰 조회 서블릿
 * @author KOSTA
 *
 */
public class SelectMemberReview extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 1. 요청 파라미터 조회
		String id = req.getParameter("id");
		String admin = req.getParameter("admin");
		
		// 비지니스로직처리
		ReviewServiceImpl rms = ReviewServiceImpl.getInstance();
		
		req.setAttribute("reviews", rms.selectReviewByMemberId(id));
		
		if(admin == null){
			req.getRequestDispatcher("/member/show_review.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("/member/show_review_admin.jsp").forward(req, resp);
		}
		
		// 3. 요청디스패치
		
	
	}
	
	
}

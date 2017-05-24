package tp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.impl.ReviewManagementServiceImpl;

public class ShowReviewServlet extends HttpServlet{
	/**
	 * 한개의 선택하 리뷰 상세보기
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		// 리뷰를 등록하고   바로 보여지는 페이지
		
		
		int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
		System.out.println("reviewNo : "+ reviewNo);	// 로그
		
		//비지니스 로직 처리 후 결과 세션속성으로 등록
		ReviewManagementServiceImpl rms = ReviewManagementServiceImpl.getInstance();
		req.setAttribute("review", rms.selectReviewByNo(reviewNo));	
		
		
		req.getRequestDispatcher("/review/output.jsp").forward(req, resp);
		
	}
	

}

package tp.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.impl.ReviewManagementServiceImpl;
import tp.vo.Review;

public class RegisterReviewServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		/* 로그인 정보 확인해서 하는 로직
		Member member = (Member)session.getAttribute("member");
		if(member == null){
		 	// 로그인 안한것이므로 로그인 요청 
		}else{
			// 여기에 처리코드 
		}
		*/
	
		// 1. 요청 파라미터 조회
		
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		String restaurantName = req.getParameter("restaurantName");
		String memberId = req.getParameter("memberId");
		Date registeredDate = new Date();
		int kostar = Integer.parseInt(req.getParameter("kostar"));
		String title = req.getParameter("title");
		String comments = req.getParameter("comments");
	
		
		// 2. 비지니스로직 처리
		ReviewManagementServiceImpl rms = ReviewManagementServiceImpl.getInstance();
		Review review = new Review(0, memberId, restaurantId, restaurantName, registeredDate, title, comments, kostar);
		rms.addReview(review);
		
		session.setAttribute("review", review);
		
		// 3. 요청 디스패처로 전달
		//우선 등록 성공페이지(register_success.jsp)에서 등록한 정보 모두 보여줌
		resp.sendRedirect("../review/output.jsp");
//		req.getRequestDispatcher("/review/output.jsp").forward(req, resp);
	
	}
	 

}

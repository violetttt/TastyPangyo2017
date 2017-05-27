package tp.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.impl.ReviewServiceImpl;
import tp.vo.Review;

public class UpdateReviewServlet extends HttpServlet{

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("UTF-8");
      //로그인 된 회원의 리뷰만 체크하기
      HttpSession session = req.getSession();
      session.getAttribute("login");
      
      //요청 파람 조회
      int reviewNo =  Integer.parseInt(req.getParameter("reviewNo").trim());
      int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
      String restaurantName = req.getParameter("restaurantName");
      String memberId = req.getParameter("memberId");
      Date registeredDate = new Date();
      int kostar = Integer.parseInt(req.getParameter("kostar"));
      String title = req.getParameter("title");
      String comments = req.getParameter("comments");
      
      //비지니스로직 처리
      ReviewServiceImpl rms = ReviewServiceImpl.getInstance();
      
      Review review = new Review(reviewNo, memberId, restaurantId, restaurantName, registeredDate, title, comments, kostar);
      rms.updateReview(review);
      System.out.println(review);
      
      // 요청파라미터로 jsp 이동
      session.setAttribute("reviews", rms.selectAllReview("registered_date"));
      resp.sendRedirect("../member/show_review.jsp");
   }
   

}
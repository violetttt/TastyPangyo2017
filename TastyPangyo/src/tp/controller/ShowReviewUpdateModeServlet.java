package tp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.impl.ReviewServiceImpl;

public class ShowReviewUpdateModeServlet extends HttpServlet{
   /**
    * 한개의 선택한 리뷰 수정모드로 보기
    */
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("UTF-8");
      HttpSession session = req.getSession();
      // 수정모드로 한개의 리뷰 보여주는 서블릿
      
      
      int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
      System.out.println("reviewNo : "+ reviewNo);   // 로그
      
      //비지니스 로직 처리 후 결과 세션속성으로 등록
      ReviewServiceImpl rms = ReviewServiceImpl.getInstance();
      req.setAttribute("review", rms.selectReviewByNo(reviewNo));   
      
      
      req.getRequestDispatcher("/member/update_form.jsp").forward(req, resp);
      
   }
  

}
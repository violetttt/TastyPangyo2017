package tp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.service.impl.ReviewServiceImpl;
import tp.vo.Member;

/**
 * 리뷰 조회 서블릿
 * @author KOSTA
 *
 */
public class SelectReviewServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  req.setCharacterEncoding("utf-8");
	      HttpSession session = req.getSession();

	      Member member = (Member)session.getAttribute("login");
	      System.out.println(member);
	      // 1. 요청 파라미터 조회
	      ReviewServiceImpl rms = ReviewServiceImpl.getInstance();
	      Enumeration<String> s = req.getParameterNames();
	      
	      
	      
	      try{   //파라미터 값이 없으면?
	         String param = s.nextElement();
	         // System.out.println(param); // 로그

	         // 파라미터의 이름(pama)을 체크해서 알맞은 service메서드를 호출해주는 메서드
	         String keyword = req.getParameter(param);
	         System.out.println("로그다 키워드 : "+keyword); // 로그

	         //공백입력 null 체그
	         /*if(keyword == null || keyword.trim().isEmpty()){
	            req.setAttribute("keyword", "*입력값이 없습니다!");
	            req.getRequestDispatcher("/review/list.jsp").forward(req, resp);
	         }*/
	         // 비지니스로직처리
	      

	         if (!member.getMemberId().equals("admin") ) { //일반회원일때는 회원아이디로 작성된 것만 보여줌
	            req.setAttribute("reviews", rms.selectReviewByMemberId(member.getMemberId()));
	            req.getRequestDispatcher("/member/show_review.jsp").forward(req, resp);
	         } else {
	            switch (param) {
	            case "allReviews":
	               req.setAttribute("reviews", rms.selectAllReview(keyword));
	               if (keyword.equals("registered_date")) {
	                  keyword = "최신 등록순 전체조회";
	               } else if (keyword.equals("review_no")) {
	                  keyword = "등록 번호순 전체조회";
	               } else if (keyword.equals("member_id")) {
	                  keyword = "작성자순 전체조회";
	               }
	               break;
	            case "title":
	               req.setAttribute("reviews", rms.selectReviewByTitle(keyword));
	               
	               break;
	            case "comments":
	               req.setAttribute("reviews", rms.selectReviewByComments(keyword));
	               break;
	            case "memberId":
	               req.setAttribute("reviews", rms.selectReviewByMemberId(keyword));
	               break;
	            case "reviewNo":
	               req.setAttribute("reviews", rms.selectReviewByNo(Integer.parseInt(keyword)));
	               break;
	            case "year":
	            case "month":
	            case "day":
	               Date registeredDate = new Date(Integer.parseInt(req.getParameter("year")),
	                     Integer.parseInt(req.getParameter("month")), Integer.parseInt(req.getParameter("day")));
	               keyword = new SimpleDateFormat("yyyy-MM-dd").format(registeredDate);
	               // System.out.println(registeredDate); //로그
	               req.setAttribute("reviews", rms.selectReviewByRegisteredDate(registeredDate));
	               break;
	            default: // 검색 값 및 정렬조건 없이 리뷰 목록 조회할 떄
	               keyword = "";
	               req.setAttribute("reviews", rms.selectAllReview("registered_date"));

	            }
	         }
	         // 검색어를 request 속성에 저장 (응답 화면에 보여주기 위해)
	         req.setAttribute("keyword", keyword);

	         
	         
	      }catch(Exception e){
	         req.setAttribute("reviews", rms.selectAllReview("registered_date"));
	         
	      }
	      // 3. 요청디스패치
	      req.getRequestDispatcher("/review/list.jsp").forward(req, resp);
	      

	   

	   }

	}

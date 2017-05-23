package tp.controller;

import java.io.IOException;
import java.sql.Date;
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
public class ReviewSelector extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 1. 요청 파라미터 조회

		Enumeration<String> s = req.getParameterNames();
		String param = s.nextElement();
		System.out.println(param);
		
		req.setAttribute("selectKeyword", req.getParameter(param));
		// 비지니스로직처리
		ReviewManagementServiceImpl rms = ReviewManagementServiceImpl.getInstance();
		req.setAttribute("reviews", rms.selectReviewByTitle(param));
		/*switch(param){
			case "title" :
				req.setAttribute("reviews", rms.selectReviewByTitle(param));
				break;
			case "comments" :
				req.setAttribute("reviews", rms.selectReviewByComments(param));
				break;
			case "registeredDate" :
				req.setAttribute("reviews", rms.selectReviewByRegisteredDate(Date.valueOf(param)));
				break;
	
		}*/
		
		// 3. 요청디스패치
		req.getRequestDispatcher("/review/list.jsp").forward(req, resp);
	
	}
	

}

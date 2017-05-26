package tp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.vo.Restaurant;
import tp.vo.Review;

public class TastyPangyoListenerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		List<Restaurant> hitsTop5 = (List<Restaurant>)getServletContext().getAttribute("hitsTop5");
		req.setAttribute("hitsTop5", hitsTop5);
		System.out.println("로그 : " +hitsTop5.get(0));
		
		List<Review> kostarTop5 = (List<Review>)getServletContext().getAttribute("kostarTop5");
		req.setAttribute("kostarTop5", kostarTop5);
		System.out.println("로그 : " +kostarTop5.get(0));
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}	
	

}

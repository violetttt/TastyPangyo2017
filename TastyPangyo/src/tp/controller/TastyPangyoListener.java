package tp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import tp.service.impl.ReviewServiceImpl;
import tp.vo.Review;

public class TastyPangyoListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		List<Review> reviews = new ArrayList<Review>();
		ReviewServiceImpl rsm;
		
		try {
			rsm = ReviewServiceImpl.getInstance();
			reviews = rsm.selectRestaurantIdByAvgKostar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		context.setAttribute("reviews", reviews);

	}
	

}

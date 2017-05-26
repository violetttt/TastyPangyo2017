package tp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import tp.service.impl.RestaurantServiceImpl;
import tp.service.impl.ReviewServiceImpl;
import tp.vo.Restaurant;
import tp.vo.Review;

public class TastyPangyoListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		List<Restaurant> list = new ArrayList<Restaurant>();
		RestaurantServiceImpl rest;



		try {
			rest = RestaurantServiceImpl.getInstance();
			// 조회수순으로 조회해서 별점 TOP5에 넣기
			list = rest.selectAllRestaurantByHit();
			context.setAttribute("hitsTop5", list);
			// 별점순으로 조회해서 별점TOP5에 넣기
			list = rest.selectRestaurantIdByAvgKostar();
			context.setAttribute("kostarTop5", list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}

package tp.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.service.impl.RestaurantServiceImpl;

public class SelectRestaurantServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	//요청 파라미터 조회
	
	Enumeration<String> s = req.getParameterNames();
	String paramName = s.nextElement();
	
	
	String resSelectKey = req.getParameter(paramName);
	req.setAttribute("resSelectKey", resSelectKey);
	
	System.out.println(paramName);
	
	//처리
	RestaurantServiceImpl service = RestaurantServiceImpl.getInstance();
	
	switch(paramName){
		case "allRes"
		:req.setAttribute("resList", service.selectAllRestaurant());
		break;
	
		case "location"
		:req.setAttribute("resList", service.selectRestaurantByLocation(resSelectKey));
		break;
		
		case "resName" 
		:req.setAttribute("resList", service.selectRestaurantByName(resSelectKey));
		break;
		
		case "foodCategory"
		:req.setAttribute("resList", service.selectRestaurantBySort(resSelectKey));
	}
	
	req.getRequestDispatcher("/restaurant/res_result.jsp").forward(req, resp);
	

	}
}

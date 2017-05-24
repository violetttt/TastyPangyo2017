package tp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.exception.NotInputDataException;

public class DeleteRestaurantServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//1. 요청파라미터 조회
		String resId = req.getParameter("resId");
		
	//2. 처리
		
		
	//3.응답
		
	}	
}

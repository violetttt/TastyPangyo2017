<%@ page contentType="text/html;charset=utf-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean scope= "request" id="review" class="tp.vo.Review"/>
<jsp:setProperty name="review" property="*"/>
<%
	// 사용할 생성자 : Review(String memberId, int restaurantId, String restaurantName, String title,String comments, int kostar)
	// 요청 디스패치 방식으로 RegisterServlet으로 이동
	//request.getRequestDispatcher("/review/register").forward(request, response);

%>

<jsp:forward page="/review/register"/>	<!-- 요청 디스패치 방식으로 RegisterServlet으로 이동 -->



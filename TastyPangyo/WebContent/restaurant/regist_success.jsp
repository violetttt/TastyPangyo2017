<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=session.getAttribute("insertRes")%>
<%=session.getAttribute("restaurantList") %>

<a href="/TastyPangyo/restaurant/manager_select_form.jsp">관리자 페이지로</a>
</body>
</html>
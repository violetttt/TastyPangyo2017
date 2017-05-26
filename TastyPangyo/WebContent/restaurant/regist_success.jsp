<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=session.getAttribute("resultRes")%><br>
<h3>등록된 맛집 정보</h3>
식당명 : ${sessionScope.insertRestaurant.restaurantName}<br>
음식종류 : ${sessionScope.insertRestaurant.foodCategory}<br>
위치 : ${sessionScope.insertRestaurant.location}<br>
소개글 : ${sessionScope.insertRestaurant.introduction}<br>
<a href="/TastyPangyo/restaurant/manager_select_form.jsp">관리자 페이지로</a>

</body>
</html>
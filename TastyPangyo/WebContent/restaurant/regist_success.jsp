<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%=session.getAttribute("insertRes")%><br>

<h3>등록된 맛집정보</h3>

식당명 : ${sessionScope.insertRestaurant.restaurantName}<br>
음식종류 : ${sessionScope.insertRestaurant.foodCategory}<br>
위치 : ${sessionScope.insertRestaurant.location}<br>
소개글 : ${sessionScope.insertRestaurant.introduction}<br><br>
<a href="/TastyPangyo/restaurant/manager_select_form.jsp">관리자 페이지로</a><br>


<!-- 삭제  -->

<c:forEach items="${requestScope.result}" var="name">
		<form action="${initParam.rootPath}/tp/imagedelete" method="post">
		<p>
		<input type="hidden" name="resId" value="${requestScope.restaurtid}">
		<input type="hidden" name="name" value="${name}"><br>
		<img src="${initParam.rootPath}/up_images/${name}" width="400px"><input type="submit" value="삭제">
		</p>
		</form>
</c:forEach><br>


<!--전체사진 삭제 -->
<form action="${initParam.rootPath}/tp/imagedelete" method="post">
	<input type="submit" value="전체 사진 삭제"><br>
</form>



</body>
</html>
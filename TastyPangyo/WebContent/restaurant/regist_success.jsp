<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%=session.getAttribute("insertRes")%>
<%=session.getAttribute("restaurantList") %>

<!-- 삭제  -->

<input type="hidden" name="resId" value="${sessionScope.restaurtid }">

<c:forEach items="${ requestScope.result }" var="name">
		<form action="${initParam.rootPath}/tp/imagedelete" method="post">
		<p>
		<input type="hidden" name="name" value="${name}">
		<img src="${initParam.rootPath }/up_images/${name}" width="400px"><input type="submit" value="삭제">
		</p>
		</form>
</c:forEach>


<!--전체사진 삭제 -->
<form action="${initParam.rootPath}/tp/imagedelete" method="post">
	<input type="submit" value="전체 사진 삭제"><br>
</form>

<a href="/TastyPangyo/restaurant/manager_select_form.jsp">관리자 페이지로</a>

</body>
</html>
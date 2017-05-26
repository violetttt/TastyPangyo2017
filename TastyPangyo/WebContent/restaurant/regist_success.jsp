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

<input type="hidden" name="restId" value="${requestScope.restaurtid }">

<!-- 삭제  -->
<<form action="${initParam.rootPath}/tp/imagedelete" method="post">
<c:forEach items="${ requestScope.result }" var="name">
		<form action="${initParam.rootPath}/tp/imagedelete" method="post">
		<p>
		<input type="hidden" name="name" value="${name}">
		<input type="hidden" name="restId" value="${requestScope.restaurtid }">
		<img src="${initParam.rootPath }/up_images/${name}" width="400px"><input type="submit" value="삭제">
		</p>
		</form>
</c:forEach>

<!--전체사진 삭제 -->
<form action="${initParam.rootPath}/tp/imagedelete" method="post">
	<input type="submit" value="전체 사진 삭제"><br>
</form>

</form>
</body>
</html>
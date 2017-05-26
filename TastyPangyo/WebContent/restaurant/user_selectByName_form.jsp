<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%--맛집이름으로 조회--%>
	<center>
	<form action="/TastyPangyo/selectRes" method="post">
	맛집이름으로 조회 :<br> <input type = "text" name="resName">
					<input type = "submit" value="조회하기">
	</form>
	</center>
	<p>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Philosopher');
h1{font-family: 'Philosopher', sans-serif; text-align:center;}
body{background-color : Bisque; text-align : center;}
</style>
</head>
<body>
<jsp:include page="/jsp/common.jsp"/>
<h1>Login</h1>
<form action="/TastyPangyo/login" method="post">
<table>
<tr>
	<td>ID</td>
	<td><input type="text" name="id" placeholder="id를 입력하세요"></td>
</tr>
<tr>
	<td>Password</td>
	<td><input type="password" name="pw" placeholder="비밀번호를 입력하세요"></td>
</tr>
</table>
<input type="submit" value="확인">


</form>
</body>
</html>
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
<h1>Join</h1>
<hr>
<form action="/TastyPangyo/join" method="post">
<table>
<tr>
	<td>아이디</td>
	<td><input type="text" name="id" placeholder="아이디를 입력하세요"></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="pw" placeholder="비밀번호를 입력하세요"></td>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="name" placeholder="이름을 입력하세요"></td>
</tr>
</table>
<input type="submit" value="가입">
</form>

</body>
</html>
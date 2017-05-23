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
a:link{
	/*방문하지 않은 링크 설정.*/
	text-decoration:none; /*밑줄 안나오도록 처리.*/
	color:black;
}
a:visited{
	/*방문한 링크 설정*/
	text-decoration: none;
	color:green;
}
a:hover{
	/*마우스 포인터가 올라간 시점의 설정.*/
	text-decoration: underline;
	color:red;
}
</style>
</head>
<body>
<h1>Tasty Pan-gyo</h1>
<hr>
<a href="login_form.jsp">&lt;로그인&gt;</a>
<a href="join_form.jsp">&lt;회원가입&gt;</a>
<hr>
<table>
	<tr>
		<th><a href="">한식</a></th>
		<th>&nbsp&nbsp&nbsp</th>
		<th><a href="">중식</a></th>
		<th>&nbsp&nbsp&nbsp</th>
		<th><a href="">일식</a></th>
		<th>&nbsp&nbsp&nbsp</th>
		<th><a href="">양식</a></th>
		<th>&nbsp&nbsp&nbsp</th>
		<th><a href="">분식</a></th>
		<th>&nbsp&nbsp&nbsp</th>
		<th><a href="">퓨전</a></th>
		<th>&nbsp&nbsp&nbsp</th>
		<th><a href="">기타</a></th>
	</tr>
</table>


</body>
</html>
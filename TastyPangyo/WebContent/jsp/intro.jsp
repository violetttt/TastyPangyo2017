<%@page import="tp.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
<h1>Tasty Pangyo</h1>
<hr>
<form action="/TastyPangyo/login" method="post">
<c:choose>

	<c:when test="${empty sessionScope.login }">
		ID : <input type="text" name="id" placeholder="id를 입력하세요">
		PW : <input type="password" name="pw" placeholder="비밀번호를 입력하세요">
		<input type="submit" value="확인">
		<a href="/TastyPangyo/member/join_form.jsp">&nbsp&nbsp&lt;회원가입&gt;</a>
	</c:when>
	
	<c:otherwise>
			<%= session.getAttribute("id") %>님 환영합니다.&nbsp
			<a href="/TastyPangyo/logout">로그아웃</a>&nbsp
			<a href="/TastyPangyo/member/myPage.jsp">마이페이지</a>
		
	</c:otherwise>
</c:choose>
</form>
<hr>
<table>
	<tr>
		<th><a href="">전체 맛집 리스트</a></th>
		<th>&nbsp&nbsp&nbsp</th>
		<th><a href="">맛집이름으로 찾기</a></th>
		<th>&nbsp&nbsp&nbsp</th>
		<th><a href="">음식종류로 찾기</a></th>
		<th>&nbsp&nbsp&nbsp</th>
		<th><a href="">맛집위치로 찾기</a></th>
		<th>&nbsp&nbsp&nbsp</th>
		<th><a href="">기타</a></th>
	</tr>
</table>


</body>
</html>
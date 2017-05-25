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
<jsp:include page="/jsp/common.jsp"/>
<h1>회원 관리</h1>
<hr>
<a href="/TastyPangyo/allmember">전체 회원 보기</a> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="/TastyPangyo/count">총회원수 보기</a> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="/TastyPangyo/member/selectById.jsp">회원 찾기</a> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="/TastyPangyo/member/selectByVisitDate.jsp">장기 미접속자 찾기</a>
<hr>
</body>
</html>
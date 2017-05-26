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
a:link{ text-decoration:none;	color:black;}
a:visited{ text-decoration: none;	color:green;}
a:hover{ text-decoration: underline;	color:red;}
</style>
</head>
<body>
<jsp:include page="/jsp/common.jsp"/>
<h1>My Page</h1>
<hr>
<a href="/TastyPangyo/member/update.jsp">정보 수정</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="/TastyPangyo/SelectMemberReview">리뷰 보기
<form action=""><input type="hidden" name ="id" value="${sessionScope.id }"></form>
</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="/TastyPangyo/member/delete.jsp">회원 탈퇴</a>
<hr>

</body>
</html>
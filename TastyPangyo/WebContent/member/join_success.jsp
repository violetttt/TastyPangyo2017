<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
<%= session.getAttribute("result") %><br>
<a href="/TastyPangyo/jsp/intro.jsp">메인페이지에서 로그인하기</a>
</body>
</html>
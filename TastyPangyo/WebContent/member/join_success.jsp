<%@page import="tp.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Philosopher');
h1{font-family: 'Philosopher', sans-serif; text-align:center;}
body{background-color : Bisque; text-align : center;}
</style>
<body>
<jsp:include page="/member/common.jsp"/>
<%= session.getAttribute("result") %><br>
<%
HttpSession ss = request.getSession();
Member m = (Member)ss.getAttribute("member");
String name = m.getMemberId();
ss.setAttribute("name", name);
%>
<%= session.getAttribute("name") %>님 환영합니다!
</body>
</html>
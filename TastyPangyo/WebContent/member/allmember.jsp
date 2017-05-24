<%@page import="tp.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/member/memberSelect.jsp"/>
모든 회원 리스트<br>
<%= request.getAttribute("allmember") %>
<c:forEach var="member" items="${requestScope.allmember}">
${member }
</c:forEach>
</body>
</html>
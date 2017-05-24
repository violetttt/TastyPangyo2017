<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/member/memberSelect.jsp"/>
최종 접속일로 회원 조회<br>
<form action="/TastyPangyo/memberByVisitDate">
<input type="date" name="visitDate">
<input type="submit">
</form>
<%= request.getAttribute("memList") %>
</body>
</html>
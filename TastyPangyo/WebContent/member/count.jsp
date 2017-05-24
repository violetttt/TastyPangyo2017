<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/member/memberSelect.jsp"/>
총 회원수 <br>
<%= request.getAttribute("memberCount") %> 명의 회원이 등록되어 있습니다.
</body>
</html>
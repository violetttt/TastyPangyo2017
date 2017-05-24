<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/member/memberSelect.jsp"/>
특정 회원 찾기<br><br>
<form action="/TastyPangyo/memberById">
<input type="text" name="id">
<input type="submit" value="검색">
</form>
</body>
</html>
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
<table border="1">
<thead>
	<tr>
		<th>회원 아이디</th>
		<th>회원 이름</th>
		<th>최종 방문일</th>
		<th>작성 리뷰</th>
	</tr>
</thead>
<tbody>
	<tr>
		<td>${memberById.memberId }</td>
		<td>${memberById.memberName }</td>
		<td>${memberById.visitDate }</td>
		<td><a href="">보기</a></td>
	</tr>
</tbody>
</table>
</body>
</html>
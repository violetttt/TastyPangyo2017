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
<c:forEach var="member" items="${requestScope.allmember}">
	<tr>
		<td>${member.memberId }</td>
		<td>${member.memberName }</td>
		<td>${member.visitDate }</td>
		<td><a href="">보기</a></td>
	</tr>
</c:forEach>
</tbody>
</table>



</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<input type="date" name="visitDate" required oninvalid="setCustomValidity('날짜를 선택해주세요!')" oninput="setCustomValidity('')">
<input type="submit" value="찾기">
</form>

<fmt:setLocale value="ko_KR"/>
<table border="1">
<thead>
	<tr>
		<th><%= request.getAttribute("date") %> 이후로 접속하지 않은 회원 리스트</th>
	</tr>
	<tr>
		<th>회원 아이디</th>
		<th>최종 방문일</th>
	</tr>
</thead>
<tbody>
<c:forEach var="member" items="${requestScope.memList}">
	<tr>
		<td>${member.memberId }</td>
		<td><fmt:formatDate value="${member.visitDate }"  pattern="yyyy-MM-dd"/></td>
	</tr>
</c:forEach>
</tbody>
<tfoot>
	<tr>
		<td>
			<form action="/TastyPangyo/deleteByVisitDate">
				<input type="submit" value="모두 삭제">
				<input type="hidden" name="date" value="<fmt:formatDate value="${member.visitDate }" type="date"/>">
			</form>
		</td>
	</tr>
</tfoot>
</table>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/member/myPage.jsp"/>
<form action="/TastyPangyo/update" method="post">
<table>
	<tr>
		<td>현재 별명</td>
		<td>${sessionScope.login.memberName }</td>

		<td>변경할 별명</td>
		<td>
			<input type="text" name="rename" placeholder="새 별명을 입력하세요">
		</td>
	</tr>
	<tr>
		<td>변경할 비밀번호</td>
		<td>
			<input type="password" name="repw" placeholder="새 비밀번호를 입력하세요">
		</td>

		<td>비밀번호 확인</td>
		<td>
			<input type="password" name="repw	" placeholder="한번 더 입력하세요">
		</td>
		<td><input type="submit" value="변경"></td>
	</tr>
</table>

</form>
</body>
</html>
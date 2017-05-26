<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/member/myPage.jsp" />
	<form action="/TastyPangyo/update" method="post">
	
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" value="${sessionScope.id }" readonly></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="repw" placeholder="새 비밀번호를 입력하세요" required oninvalid="setCustomValidity('비밀번호를 입력해주세요!')" oninput="setCustomValidity('')"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="repw" placeholder="한번 더 입력하세요" required oninvalid="setCustomValidity('비밀번호를 확인해주세요!')" oninput="setCustomValidity('')"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="rename" placeholder="${sessionScope.login.memberName }" required oninvalid="setCustomValidity('이름을 입력해주세요!')" oninput="setCustomValidity('')"></td>
				<td><input type="submit" value="변경"></td>
			</tr>
		</table>


	</form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/member/myPage.jsp"/>
본인확인을 위해 비밀번호를 다시한번 입력해주세요.<br><br>
<form action="/TastyPangyo/delete" method="post">
	<input type="password" name= "pw" placeholder="탈퇴하지마세요ㅠㅠ" required oninvalid="setCustomValidity('비밀번호를 입력해주세요!')" oninput="setCustomValidity('')">
	<input type="hidden"  name="id" value="${sessionScope.id }">
	<input type="submit" value="확인" onclick="alert('탈퇴되었습니다.')">

</form>
</body>
</html>
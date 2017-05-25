<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/member/myPage.jsp"/>
'${sessionScope.login.memberName }'님의 정보가 수정되었습니다.
</body>
</html>
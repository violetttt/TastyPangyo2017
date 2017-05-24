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
		<td></td>
	</tr>
	<tr>
		<td>변경할 별명</td>
		<td>
			<input type="text" name="rename" placeholder="변경하실 별명을 입력하세요">
			<input type="submit" value="변경">
		</td>
	</tr>
</table>

</form>
</body>
</html>
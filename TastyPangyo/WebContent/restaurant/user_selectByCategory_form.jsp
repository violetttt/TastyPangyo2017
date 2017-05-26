<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 맛집 --%>
<center>
	<form action="/TastyPangyo/selectRes" method="post">
	음식 종류 :<br>한식<input type = "radio" name="foodCategory" value="한식" checked="checked"><br>
				   양식<input type = "radio" name="foodCategory" value="양식" ><br>
				   중식<input type = "radio" name="foodCategory" value="중식"><br>
				   일식<input type = "radio" name="foodCategory" value="일식" ><br>
				  기타<input type = "radio" name="foodCategory" value="기타" ><br>
				<input type = "submit" value ="조회하기">
	</form>			
	<p>
	</center>
</body>
</html>
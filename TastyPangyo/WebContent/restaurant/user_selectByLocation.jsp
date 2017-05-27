<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--맛집 건물으로 조회 --%>
	<center>
	<form action="/TastyPangyo/selectRes" method="post">
	맛집 위치 :<br> 삼환하이펙스A<input type = "radio" name="location" value="삼환하이펙스A" checked="checked"><br>
				   삼환하이펙스B<input type = "radio" name="location" value="삼환하이펙스B" ><br>
				   유스페이스1  <input type = "radio" name="location" value="유스페이스1"><br>
				   유스페이스2  <input type = "radio" name="location" value="유스페이스2" ><br>
				  H스퀘어	  <input type = "radio" name="location" value="H스퀘어" ><br>
				  <input type = "submit" value ="조회하기">				  
	</form>
	</center>
	<p>
</body>
</html>
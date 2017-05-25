<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<center>
<body>

<%--전체조회 --%>
	<form action = "/TastyPangyo/selectRes" method ="post">
	<input type = "submit" name = "allRes" value ="전체조회">
	</form>
	<p>

<%--맛집이름으로 조회--%>
	<form action="/TastyPangyo/selectRes" method="post">
	맛집이름으로 조회 :<br> <input type = "text" name="resName">
					<input type = "submit" value="조회하기">
	</form>
	<p>
	
<%--맛집 건물으로 조회 --%>
	<form action="/TastyPangyo/selectRes" method="post">
	맛집 위치 :<br> 삼환하이펙스A<input type = "radio" name="location" value="삼환하이펙스A" ><br>
				   삼환하이펙스B<input type = "radio" name="location" value="삼환하이펙스B" ><br>
				   유스페이스1  <input type = "radio" name="location" value="유스페이스1"><br>
				   유스페이스2  <input type = "radio" name="location" value="유스페이스2" ><br>
				  H스퀘어	  <input type = "radio" name="location" value="H스퀘어" ><br><br>
				  <input type = "submit" value ="조회하기">
	</form>
	<p>
	
<%-- 맛집 --%>
	<form action="/TastyPangyo/selectRes" method="post">
	음식 종류 :<br>한식<input type = "radio" name="foodCategory" value="한식" ><br>
				   양식<input type = "radio" name="foodCategory" value="양식" ><br>
				   중식<input type = "radio" name="foodCategory" value="중식"><br>
				   일식<input type = "radio" name="foodCategory" value="일식" ><br>
				  기타<input type = "radio" name="foodCategory" value="기타" ><br><br>
				<input type = "submit" value ="조회하기">
	</form>			
	<p>

</body>
</center>
</html>
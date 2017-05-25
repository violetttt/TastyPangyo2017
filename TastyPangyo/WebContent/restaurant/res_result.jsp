<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
		<thead>
			<tr>
				<th width="50px">  식당명        </th>
				<th width="100px"> 음식종류     </th>
				<th width="100px"> 위치 		  </th>
				<th width="100px"> 음식점 번호  </th>
				<th width="500px"> 소개글        </th>				
			</tr>
		</thead>
		<tbody>
	
	<c:forEach items="${requestScope.resList}" var = "res">	
			<tr align="center">
				<td>${res.restaurantName}</td>
				<td>${res.foodCategory}</td>
			 	<td>${res.location}</td>
				<td>${res.restaurantTelNum}</td>
				<td>${res.introduction}</td>
			</tr>
	</c:forEach>
	</tbody>
	
	</table>
</body>
</html>
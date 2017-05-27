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
				<th width="100px"> 식당명        </th>
				<th width="100px"> 음식종류     </th>
				<th width="150px"> 위치 		  </th>
				<th width="100px"> 음식점 번호  </th>
				<th width="500px"> 소개글        </th>
				<th width="100px"> 조회수	 </th>	
				<th width="30px">  삭제		  </th>
				<th width="30px">  변경		  </th>
			</tr>
		</thead>
		<tbody>
	
		<c:forEach items="${sessionScope.resList}" var = "res">	
			<tr align="center">
				<td><a href = "/TastyPangyo/selectResById?restaurantId=${res.restaurantId}">${res.restaurantName}</a></td>
				<td>${res.foodCategory}</td>
			 	<td>${res.location}</td>
				<td>${res.restaurantTelNum}</td>
				<td><center>${res.introduction}</center></td>
				<td>${res.hits}</td>
				<td>
					<form action = "/TastyPangyo/deleteRes">
					<input type ="submit" value = "맛집삭제" name = "${res.restaurantId}">
					</form>
				</td>
				<td>
					<form action = "/TastyPangyo/restaurant/update_restaurant_form.jsp">
					<input type ="hidden" name = "PK" value = "${res.restaurantId}">
					<input type ="submit" value = "맛집수정">
					</form>
				</td>
				
			</tr>
		</c:forEach>
	</tbody>
	
	</table>
</body>
</html>
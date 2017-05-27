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
				<th width="100px">  식당명        </th>
				<th width="100px"> 음식종류     </th>
				<th width="150px"> 위치 		  </th>
				<th width="100px"> 음식점 번호  </th>
				<th width="500px"> 소개글        </th>
				<th width="100px"> 조회수	 </th>	
			</tr>
		</thead>
		<tbody>
	
	<c:forEach items="${sessionScope.resList}" var = "res">	
			<tr align="center">
				<c:choose>												<%-- 로그인을 하지 않았으면, 상세정보를 클릭할 수 없도록한다. --%>
					<c:when test="${empty sessionScope.login}">
						<td>${res.restaurantName}</td>
					</c:when>
					<c:otherwise>
						<td><a href = "/TastyPangyo/selectResById?restaurantId=${res.restaurantId}">${res.restaurantName}</a></td>
									<%--상세 정보를 볼 맛집 id를 서블릿으로 넘긴다. --%>																				
					</c:otherwise>
				</c:choose>
				<td>${res.foodCategory}</td>
			 	<td>${res.location}</td>
				<td>${res.restaurantTelNum}</td>
				<td>${res.introduction}</td>
				<td>${res.hits }</td>		
			</tr>
	</c:forEach>
	</tbody>
	</table>
	${requestScope.errorMessage}
	
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 리뷰index 화면 고정 -->
<jsp:include page="/review/select_index.jsp"/>

<h3>리뷰목록</h3>
"${ requestScope.selectKeyword }"(으)로 찾은 결과입니다.<br>
<table border="1">
	<thead>
		<tr>
			<th width="50px"> NO </th>
			<th width="100px"> 식당명 </th>
			<th width="100px"> 별점 </th>
			<th width="500px"> 제목 </th>
			<th width="200px"> 작성일</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${ requestScope.reviews }" var="review">
		<tr>
			<td> ${ review.reviewNo } </td>
			<td> ${ review.restaurantName }</td>
			<td> ${ review.kostar }</td>
			<td> ${ review.title }</td>
			<td> <fmt:formatDate value="${ review.registeredDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
	</c:forEach>
	</tbody>
</table>



</body>
</html>
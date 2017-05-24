<%@page import="java.text.SimpleDateFormat"%>
<%@page import="tp.vo.Review"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<!-- 리뷰index 화면 고정 -->
<jsp:include page="/review/select_index.jsp"/>

<!-- 선택한 리뷰보기  -->
<h3>선택리뷰보기</h3>

<table border="1" width="630px">
	<tr height="12px">
		<th id="review_item"> 식당번호 </th>
		<td> ${ requestScope.review.restaurantId }</td>
		<th id="review_item"> 식당명 </th>
		<td> ${ requestScope.review.restaurantName }</td>
		<th id="review_item"> 별점 </th>
		<td> ${ requestScope.review.kostar }</td>
	</tr>
	<tr height="12px">
		<th id="review_item"> 작성자 </th>
		<td> ${requestScope.review.memberId }</td>
		<th id="review_item"> 작성일 </th>
		<td colspan="3"> <fmt:formatDate value="${ requestScope.review.registeredDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	<tr height="12px">
		<th id="review_item"> 제목 </th>
		<td colspan="5"> ${ requestScope.review.title }</td>
	<tr>
		<th id="review_item"> 내용 </th>
		<td colspan="5"> ${ requestScope.review.comments }</td>
	</tr>
</table>
<br>
<form action="/TastyPangyo/review/select" method="post">
	<button type="submit" name="allReviews" value="registered_date">전체목록보기</button>
</form> 

</body>
</html>
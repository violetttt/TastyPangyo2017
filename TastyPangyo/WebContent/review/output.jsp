<%@page import="java.text.SimpleDateFormat"%>
<%@page import="tp.vo.Review"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% 
	/* Review review = (Review)session.getAttribute("registerReview");

	session.setAttribute("registeredDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(review.getRegisteredDate()));
 */
%>


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
		<td> ${ sessionScope.registerReview.restaurantId }</td>
		<th id="review_item"> 식당명 </th>
		<td> ${ sessionScope.registerReview.restaurantName }</td>
		<th id="review_item"> 별점 </th>
		<td> ${ sessionScope.registerReview.kostar }</td>
	</tr>
	<tr height="12px">
		<th id="review_item"> 작성자 </th>
		<td> ${sessionScope.registerReview.memberId }</td>
		<th id="review_item"> 작성일 </th>
		<td colspan="3"> <fmt:formatDate value="${ sessionScope.registerReview.registeredDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	<tr height="12px">
		<th id="review_item"> 제목 </th>
		<td colspan="5"> ${ sessionScope.registerReview.title }</td>
	<tr>
		<th id="review_item"> 내용 </th>
		<td colspan="5"> ${ sessionScope.registerReview.comments }</td>
	</tr>
</table>

</body>
</html>
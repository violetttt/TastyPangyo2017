<%@page import="java.util.Date"%>
<%@page import="tp.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 세션으로 받은 레스토랑 정보, 로그인 정보로 화면 리스트 뿌려주기 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 리뷰index 화면 고정 -->
<jsp:include page="/review/index.jsp"/>

<h3>리뷰목록</h3>
<form action="/TastyPangyo/review/remove" method="post"><!-- 관리모드를 위한 폼 -->

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
	<c:forEach items="${ reviews }" var="review">	
		<tr>
			<td> ${ review.reviewNo } </td>
			<td> ${ review.restaurantName }</td>
			<td> ${ review.kostar }</td>
			<td><a href ="/TastyPangyo/review/show?reviewNo=${ review.reviewNo }">${ review.title }</a> </td>
			<td> <fmt:formatDate value="${ review.registeredDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td style="text-align:center"> <input type="checkbox" name="reviewNo" value="${ review.reviewNo }"></td>
			<td style="text-align:center">  <a href="/TastyPangyo/review/show/update-mode?reviewNo=${ review.reviewNo }&updateCk=yes"><input type="button" value="수정"></a></td>			
		</tr>
	</c:forEach>
	</tbody>
</table>
</form>
</body>
</html>
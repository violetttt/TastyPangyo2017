<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%  %>
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
<% if( request.getAttribute("keyword") != null){ %>
${ requestScope.keyword }"(으)로 찾은 결과입니다.<br>
<%} %>


<form action="/TastyPangyo/review/remove" method="post"><!-- 관리모드를 위한 폼 -->


<table border="1">
	<thead>
		<tr>
			<th width="50px"> NO </th>
			<th width="100px"> 식당명 </th>
			<th width="100px"> 별점 </th>
			<th width="500px"> 제목 </th>
			<th width="150px"> 작성자</th>
			<th width="200px"> 작성일</th>
			<th width="50px"> 선택</th> <!-- 관리모드에서 삭제를 위한 체크박스 -->
		</tr>
	</thead>
	<tfoot>
		<tr>
		<td colspan="7" style="text-align: center">
		<input type="submit" value="삭제" onclick="리뷰를 삭제합니다!">
		</td>
		</tr>
	</tfoot>
	<tbody>
	<c:forEach items="${ reviews }" var="review">	
		<tr>
			<td> ${ review.reviewNo } </td>
			<td> ${ review.restaurantName }</td>
			<td> ${ review.kostar }</td>
			<td><a href ="/TastyPangyo/review/show?reviewNo=${ review.reviewNo }">${ review.title }</a> </td>
			<td> ${ review.memberId }</td>
			<td> <fmt:formatDate value="${ review.registeredDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td style="text-align:center"> <input type="checkbox" name="reviewNo" value="${ review.reviewNo }"></td>
		</tr>
		
		
	</c:forEach>
	</tbody>
</table>

</form>


</body>
</html>
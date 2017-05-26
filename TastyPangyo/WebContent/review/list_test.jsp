<%@page import="java.util.Date"%>
<%@page import="tp.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<h3>리뷰목록</h3>
<% if( request.getAttribute("keyword") != null ){ %>
"${ requestScope.keyword }"(으)로 찾은 결과입니다.<br>
<%	} %>


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
			<!-- 관리자만 볼수있게 !!!! -->
			<c:if test="${ sessionScope.login.memberId == 'admin' and sessionScope.login.memberPw == '1234' }">
				<th width="50px"> 선택</th> <!-- 관리모드에서 삭제를 위한 체크박스 -->
				<th width ="60px"> 수정 </th>
			</c:if>
		</tr>
	</thead>
	<c:if test="${ sessionScope.login.memberId == 'admin' and sessionScope.login.memberPw == '1234' }">
	<tfoot>
		<tr>
		<td colspan="8" style="text-align: center">
		<input type="hidden" name="deleteCk" value="yes">
		<input type="submit" value="삭제" onclick="confirm('선택한 리뷰를 삭제합니다')">
		</td>
		</tr>
	</tfoot>
	</c:if>
	<tbody>
	<c:forEach items="${ requestScope.reviews }" var="review">	
		<tr>
			<td> ${ review.reviewNo } </td>
			<td> ${ review.restaurantName }</td>
			<td> ${ review.kostar }</td>
			<td><a href ="/TastyPangyo/review/show?reviewNo=${ review.reviewNo }">${ review.title }</a> </td>
			<td> ${ review.memberId }</td>
			<td> <fmt:formatDate value="${ review.registeredDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<c:if test="${ sessionScope.login.memberId == 'admin' and sessionScope.login.memberPw == '1234' }" >
			<td style="text-align:center"> <input type="checkbox" name="reviewNo" value="${ review.reviewNo }"></td>
			<td style="text-align:center">  <a href="/TastyPangyo/review/show/update-mode?reviewNo=${ review.reviewNo }&updateCk=yes"><input type="button" value="수정"></a></td>
			</c:if>		
		</tr>
		
	</c:forEach>
	</tbody>
</table>

</form>


</body>
<% session.removeAttribute("reviews"); %>
</html>
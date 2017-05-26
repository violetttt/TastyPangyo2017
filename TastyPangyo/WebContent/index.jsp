<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
td{
 width: 300px;
 text-align: center;
}
</style>


<body>
<!-- 메이화면 페이지 -->
	<fieldset class="review_form" size="150">
				<legend class="screen_out">별점 TOP5</legend>
	<table> 
		<tr>
			<c:forEach items="${ applicationScope.reviews }" var="review">
				<td>
				<!-- top 5 별점 조회수 -->
				${ review }
				
				</td>
			</c:forEach>
		</tr>
	</table>
	</fieldset>





</body>
</html>
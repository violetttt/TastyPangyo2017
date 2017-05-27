<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>

<!-- 리뷰index 화면 고정 -->
<jsp:include page="/member/myPage.jsp"/>

	<h3>리뷰 등록 페이지</h3>
	<div class="review_form">
		<form id="review_form" action="/TastyPangyo/review/update" method="post">
			<fieldset class="review_form" size="150">
				<legend class="screen_out">리뷰수정 form</legend>
				<div class="row_group">
					<!-- 필수입력값(NOT NULL이여야 하는)은 input 속성으로 required를 줘서 반드시 입력값을 받고 넘어가게 하고
					 oninvalid  -->
					 <!-- 화면에 보여줄 필요없지만 함께 넘겨줘야하는 값(e.g. reviewNo를 매개변수로 업데이트)은 hidden타입으로,
					 	  수정할 필욯없는 것은 readonly속성으로  -->
					 <input type="hidden" name="reviewNo" value="${ requestScope.review.reviewNo }">
					식당번호 <input id="readonly" name="restaurantId" value="${ requestScope.review.restaurantId }" size="40" readonly><br>
					식당명 <input id="readonly" name="restaurantName" value="${ requestScope.review.restaurantName }" size="40" readonly><br>
							
					작성자 <input id="readonly" name="memberId" value="${ requestScope.review.memberId }" size="40" readonly><br>
					별점 <span class="kostar">
						  <span class="input">
						  	<c:forEach begin="1" end="10" var="no">
						  	<c:choose>
						  		<c:when test="${ requestScope.review.kostar == no }">
							  		<input type="radio" name="kostar" id="p${no}" value="${no}" checked><label for="p${no}">${no}</label>
						  		</c:when>
						 		<c:otherwise>
						 	 		<input type="radio" name="kostar" id="p${no}" value="${no}"><label for="p${no}">${no}</label>
						 		</c:otherwise>
						 		</c:choose>
						  	</c:forEach>
						  </span>
						  <output for="kostar"><b> </b>점</output>
						</span>
						<br>
					제목 <input type="text" name="title" value="${ requestScope.review.title }"  size="100" required>
					<p>
					<textarea name="comments" rows="10" cols="107" required>${ requestScope.review.comments }</textarea>
					</p>
				</div>
				<input type="reset" value="입력초기화">
				<a href="/TastyPangyo/member/show_review.jsp" ><input type="button" value="돌아가기" ></a>
		 		<input type="submit" value="리뷰수정" onclick="alert('수정되었습니다.')">
			
			</fieldset>
			
		</form>
	</div>



</body>
</html>
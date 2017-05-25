<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 리뷰index 화면 고정 -->
<jsp:include page="/review/select_index.jsp"/>

<!-- 전체목록 조회 -->
<form action="/TastyPangyo/review/select" method="post">
	전체목록 
	<select name="allReviews">
		<option value="registeredDate">최신등록순</option>
		<option value="reviewNo">리뷰번호순</option>
		<option value="memberId">작성자순</option>
	</select>
	<input type="submit" value="리뷰검색"><br>
	</form>
<hr>

<!-- 제목으로 찾기 -->
<form action="/TastyPangyo/review/select" method="post">
	제목으로 찾기 <input type="text" name="title" placeholder="제목 일부를 입력하세요"> 
	<input type="submit" value="리뷰검색"><br>
</form>
<hr>

<form action="/TastyPangyo/review/select" method="post">
	내용으로 찾기 <input type="text" name="comments" placeholder="내용 일부를 입력하세요">
	<input type="submit" value="리뷰검색"><br>
</form>
<hr>
<form action="/TastyPangyo/review/select" method="post">
	작성자로 찾기 <input type="text" name="memberId" placeholder="아이디를 입력하세요">
	<input type="submit" value="리뷰검색"><br>
</form>
<hr>
<form action="/TastyPangyo/review/select" method="post">
	작성일로 찾기
	<!-- 년 -->
	<select name="year">
		<option value="2017">2017</option>
		<option value="2016">2016</option>
		<option value="2015">2015</option>
		<option value="2014">2014</option>
	</select>
	<!-- 월 -->	
	<select name="month">
		<option value="01">1</option>
		<option value="02">2</option>
		<option value="03">3</option>
		<option value="04">4</option>
		<option value="05">5</option>
		<option value="06">6</option>
		<option value="07">7</option>
		<option value="08">8</option>
		<option value="09">9</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
	</select>
	<!-- 일 -->	
	<select name="day">
		<option value="01">1</option>
		<option value="02">2</option>
		<option value="03">3</option>
		<option value="04">4</option>
		<option value="05">5</option>
		<option value="06">6</option>
		<option value="07">7</option>
		<option value="08">8</option>
		<option value="09">9</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
		<option value="13">13</option>
		<option value="14">14</option>
		<option value="15">15</option>
		<option value="16">16</option>
		<option value="17">17</option>
		<option value="18">18</option>
		<option value="19">19</option>
		<option value="20">20</option>
		<option value="01">21</option>
		<option value="02">22</option>
		<option value="03">23</option>
		<option value="04">24</option>
		<option value="05">25</option>
		<option value="06">26</option>
		<option value="07">27</option>
		<option value="08">28</option>
		<option value="09">29</option>
		<option value="10">10</option>
	</select>
	
	<input type="submit" value="리뷰검색"><br>
</form>		

</body>
</html>
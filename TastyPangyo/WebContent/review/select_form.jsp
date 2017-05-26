<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 리뷰index 화면 고정 -->
<jsp:include page="/review/index.jsp"/>


<!-- 리뷰등록페이지로 가기 -->
<a href ="/TastyPangyo/review/register_form.jsp" ><input type="button" value="리뷰등록페이지로"></a><br>
<hr>	
<!-- 전체리뷰 가기 -->
<a href ="/TastyPangyo/review/select" >전체리뷰</a><br>
<hr>

<!-- 전체리뷰 가기 -->
<a href ="/TastyPangyo/review/select?select=${sessionScope.login.memberId}" >내리뷰</a><br>
<hr>
<!-- 전체목록 조회 -->
<form action="/TastyPangyo/review/select" method="post">
	전체목록 
	<select name="allReviews">
		<option value="registered_date">최신등록순</option>
		<option value="review_no">리뷰번호순</option>
		<option value="member_id">작성자순</option>
	</select>
	<input type="submit" value="리뷰검색"><br>
	</form>
<hr>

<!-- 제목으로 찾기 -->
<form action="/TastyPangyo/review/select" method="post">
	제목으로 찾기 <input type="search" name="title" placeholder="제목 일부를 입력하세요" required oninvalid="alert('값을 입력하세요!')"> 
	<input type="submit" value="리뷰검색"><br>
</form>
<hr>

<form action="/TastyPangyo/review/select" method="post">
	내용으로 찾기 <input type="search" name="comments" placeholder="내용 일부를 입력하세요" required oninvalid="alert('값을 입력하세요!')">
	<input type="submit" value="리뷰검색"><br>
</form>
<hr>
<form action="/TastyPangyo/review/select" method="post">
	작성자로 찾기 <input type="search" name="memberId" placeholder="아이디를 입력하세요" required oninvalid="alert('값을 입력하세요!')">
	<input type="submit" value="리뷰검색"><br>
</form>
<hr>
<form action="/TastyPangyo/review/select" method="post">
	작성일로 찾기
	<!-- 년 -->
	<select name="year">
		<option  value="117">2017</option>
		<option value="116">2016</option>
		<option value="115">2015</option>
		<option value="114">2014</option>
	</select>
	<!-- 월 -->	
	<select name="month">
		<option value="0">1</option>
		<option value="1">2</option>
		<option value="2">3</option>
		<option value="3">4</option>
		<option value="4">5</option>
		<option value="5">6</option>
		<option value="6">7</option>
		<option value="7">8</option>
		<option value="8">9</option>
		<option value="9">10</option>
		<option value="10">11</option>
		<option value="11">12</option>
	</select>
	<!-- 일 -->	
	<select name="day">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
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
		<option value="21">21</option>
		<option value="22">22</option>
		<option value="23">23</option>
		<option value="24">24</option>
		<option value="25">25</option>
		<option value="26">26</option>
		<option value="27">27</option>
		<option value="28">28</option>
		<option value="29">29</option>
		<option value="30">30</option>
		<option value="31">31</option> 	
	</select>
	<input type="submit" value="리뷰검색"><br>

</form>
<hr>

</body>
</html>


<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Philosopher');

h1 {
	font-family: 'Philosopher', sans-serif;
	text-align: center;
}

a:link {
	/*방문하지 않은 링크 설정.*/
	text-decoration: none; /*밑줄 안나오도록 처리.*/
	color: black;
}

a:visited {
	/*방문한 링크 설정*/
	text-decoration: none;
	color: green;
}

a:hover {
	/*마우스 포인터가 올라간 시점의 설정.*/
	text-decoration: underline;
	color: red;
}
/***************************************메뉴 CSS 설정**********************************************/
#nav { /* 메뉴 전체 영역에 대한 스타일 */
	list-style-type: none; /* 불릿 기호 없앰 */
	height: 45px; /* 내비게이션 높이 */
	padding: 6px 7px; /* 위아래 6px, 좌우 7px씩 안여백 */
	margin: 0; /* 바깥 여백 없음 */
	background: #7d7d7d; /* 내비게이션 전체 배경색 */
	border-radius: 1.5em; /* 모서리 둥글게 */
}

#nav li { /* 메뉴 각 항목에 대한 스타일 */
	float: left; /* 왼쪽부터 표시 */
	position: relative; /* 순서대로 표시 */
	margin: 5px 10px; /* 위아래 5px, 좌우 10px씩 바깥 여백 */
	padding: 0; /* 안여백 없음 */
}

#nav li a { /* 메뉴 항목에서도 링크에 대한 스타일 */
	display: block; /* 영역을 만듦 */
	font-family: "굴림"; /* 글꼴 */
	font-weight: 600; /* 진하게 */
	font-size: 1em; /* 글자크기 */
	padding: 10px 20px; /* 안여백 */
	color: #e7e5e5; /* 링크 글자색 */
	text-decoration: none; /* 밑줄 없앰 */
	margin: 0; /* 바깥 여백 없음 */
	border-radius: 1.4em; /* 링크의 모서리를 둥글게 */
	text-shadow: 0 1px 1px rgba(0, 0, 0, .3); /* 텍스트 그림자 */
}

#nav li:hover>a { /* 메뉴 항목 위로 마우스 올렸을 때 스타일 */
	background: #ebebeb; /* 배경색 */
	color: #444; /* 글자색 */
	text-shadow: 0 1px 1px rgba(255, 255, 255, 1); /* 글자 그림자 */
	border-radius: 1.4em; /* 모서리 둥글게 */
	-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.2); /* 메뉴 항목에 그림자 */
	-moz-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.2); /* 메뉴 항목에 그림자 */
}

#nav ul { /* 서브 메뉴 영역에 대한 스타일 */
	margin: 0; /* 서브 메뉴 바깥 여백 없음 */
	padding: 0; /* 서브 메뉴 안여백 없음 */
	list-style: none; /* 목록의 불릿 없앰 */
	position: absolute; /* 고정 위치에 표시 */
	left: 0; /* 부모 요소와 left 좌표 값은 같게 */
	top: 45px; /* 부모 요소로부터 아래로 45px 밑에 표시 */
	width: 150px; /* 서브 메뉴 너비 */
	background: #ddd; /* 서브 메뉴 배경색 */
	border: 1px solid #b4b4b4; /* 서브 메뉴 테두리를 그림 */
	border-radius: 8px; /* 모서리를 둥글게 처리 */
	box-shadow: 0 1px 3px rgba(0, 0, 0, .3);
	opacity: 0; /* 투명하게 표시 - 결국 평소엔 안보임 */
}

#nav ul li { /* 서브 메뉴 각 항목의 스타일 */
	float: none; /* 세로로 표시 */
	margin: 0; /* 바깥 여백 없음 */
	padding: 0; /* 안 여백 없음 */
	height: 0; /* 화면에서 감춤 */
	overflow: hidden; /* height:0을 해도 보이는 부분이 있다면 감춤 */
}

#nav li:hover  ul { /* 메인 메뉴 위로 마우스 오버했을 때 서브 메뉴 스타일 */
	opacity: 1; /* 서브 메뉴 불투명해짐 -> 화면에 보임 */
}

#nav li:hover ul li {
	height: 35px; /* 서브 메뉴 항목의 높이 */
	overflow: visible; /* 메뉴 영역을 넘어서는 내용이 있다면 표시 */
	padding: 0; /* 안여백 없음 */
}

#nav ul a { /* 서브 메뉴 항목의 링크 스타일 */
	font-weight: normal; /* 진하기 보통으로 */
	text-shadow: 0 1px 0 #fff; /* 글자 그림자 */
	color: #333; /* 글자색 */
}

#nav ul li:hover>a { /* 서브 메뉴 항목 위로 마우스 오버했을 때의 스타일 */
	background: #0078ff; /* 배경색 */
	color: #fff; /* 글자색 */
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1); /* 글자 그림자 */
	border-radius: 0; /* 모서리 둥글게 처리 안함 */
}

#nav ul li:first-child>a { /* 서브 메뉴 첫번째 항목의 스타일 */
	border-top-left-radius: 8px; /* 왼쪽 윗부분 둥글게 */
	border-top-right-radius: 8px; /* 오른쪽 윗부분 둥글게 */
}

#nav ul li:last-child>a { /* 서브 메뉴 마지막 항목의 스타일 */
	border-bottom-left-radius: 8px; /* 왼쪽 아랫부분 둥글게 */
	border-bottom-right-radius: px; /* 오른쪽 아랫부분 둥글게 */
}
/********************************************************************************************/

/*******************************페이지 나누는 css설정*************************************/
#div_root { /* 전체 */
	margin-top: 5px;
	margin-left: 20px;
	margin-right: 5px;
	margin-bottom: 5px;
	width: 1200px;
}

#div_top { /*사진/배너 */
	width: 120%;
	height: 200px;
	background: url('/board/2.jpg') no-repeat;
	/*2.jpg(음식사진)을 경로에 넣어서 바꿔줘야함*/
	background-size: cover;
	text-align: center;
	font-family: '굴림';
	font-size: 3em;
	color: white;
	border-width: medium;
}

#div_menu { /*메뉴바 */
	width: 120%;
	height: 50px;
	float: left;
	backgroud-color: #819FF7;
	text-align: left;
}

#div_con { /* 내용칸 */
	width: 120%;
	height: 700px;
	float: left;
	background-color:;
	text-align: left;
}

#div_bottom { /* 소개칸 */
	width: 120%;
	height: 50px;
	clear: both;
	background-color:;
	text-align: center;
	border-top-width: 2px;
}

/************************************* P태그 ID CSS설정 ****************************** */
#p1 {
	border-color: black;
	border-style: solid;
	padding: 10px;
	border-top-width: 5px;
	border-right-width: 0;
	border-bottom-width: 5px;
	border-left-width: 0;
}
/****************************************************************************************/

/*****************************맛집 TOP5, 별점 TOP5 CSS 설정****************************/
.content1 {
	width: 100%;
	height: 620px;
	border: 1px solid black;
	background: lightyellow;
	padding: 5px; /* 네 방향의 패딩 모두 5px */
	text-align: center;
}

.content2 {
	width: 100%;
	height: 310px;
	border: 1px solid black;
	background: lightyellow;
	padding: 5px; /* 네 방향의 패딩 모두 5px */
}
/*****************************************************************************************/
</style>
</head>


<!--------------------------------- BODY 대신 DIV 사용------------------------------------------>
<div id="div_root">


	<!----------------------------------그림있는 상단 설정------------------------------------------->
	<div id="div_top">
		<h1>Tasty Pangyo</h1>
	</div>


	<!-------------------------------------메뉴바 설정----------------------------------------------->
	<div id="div_menu">
		<ul id="nav">
			<li><a href="/TastyPangyo/logout"> 처음으로 </a></li>
			<li><a>회원 관리</a>
			  	<ul>
			  	<li><a href="/TastyPangyo/allmember">전체 회원 보기</a></li>
				<li><a href="/TastyPangyo/count">총 회원 수</a></li>
				<li><a href="/TastyPangyo/member/selectById.jsp">회원 찾기</a></li>
				<li><a href="/TastyPangyo/member/selectByVisitDate.jsp">장기 미접속자</a></li>
				</ul></li>
		</ul>
	</div>
	<br> <br> <br> <br>

	<!---------------------------------------내용 설정-------------------------------------------->
	<div id="div_con">
		<div class="content1">
			<h1>회원 찾기</h1>
			<p>
			<form action="/TastyPangyo/memberById">
				<input type="text" name="id"> <input type="submit"
					value="검색">
			</form>
			<p>
			<table border="1" align="center">
				<thead>
					<tr>
						<th>회원 아이디</th>
						<th>회원 이름</th>
						<th>최종 방문일</th>
						<th>작성 리뷰</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${memberById.memberId }</td>
						<td>${memberById.memberName }</td>
						<td>${memberById.visitDate }</td>
						<td><a href="">보기</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


	<!---------------------------------------소개 내용---------------------------------------------->
	<div id="div_bottom">
		<p id="p1">
			Tasty Pangyo 경기 성남시 분당구 대왕판교로 660 www.kosta.or.kr<br> 대표이사 서현화
			대표전화 02-XXXX-XXXX
		</p>


	</div>
</div>


</html>
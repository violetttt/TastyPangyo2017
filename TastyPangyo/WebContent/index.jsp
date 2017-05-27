<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="tp.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판교 맛집 검색 NO1 사이트 Tasty Pangyo</title>
<style type="text/css">

 /***************************************메뉴 CSS 설정**********************************************/ 
 
  #nav {  /* 메뉴 전체 영역에 대한 스타일 */
     list-style-type: none; /* 불릿 기호 없앰 */
     height: 45px; /* 내비게이션 높이 */
     padding: 6px 7px;  /* 위아래 6px, 좌우 7px씩 안여백 */
     margin: 0;  /* 바깥 여백 없음 */
     background:#7d7d7d;  /* 내비게이션 전체 배경색 */
     border-radius:1.5em;  /* 모서리 둥글게 */
  }
  #nav li { /* 메뉴 각 항목에 대한 스타일 */
     float: left; /* 왼쪽부터 표시 */5
     position: relative; /* 순서대로 표시 */
     margin:5px 10px;  /* 위아래 5px, 좌우 10px씩 바깥 여백 */
     padding: 0; /* 안여백 없음 */
  }
  #nav li a { /* 메뉴 항목에서도 링크에 대한 스타일 */
     display: block; /* 영역을 만듦 */
     font-family:"굴림"; /* 글꼴 */
     font-weight:600; /* 진하게 */
     font-size:1em;   /* 글자크기 */
     padding:10px 20px; /* 안여백 */
     color: #e7e5e5; /* 링크 글자색 */
     text-decoration: none; /* 밑줄 없앰 */
     margin:0;  /* 바깥 여백 없음 */
     border-radius:1.4em;   /* 링크의 모서리를 둥글게 */
     text-shadow:0 1px 1px rgba(0,0,0,.3);  /* 텍스트 그림자 */
  }
  #nav li:hover > a{  /* 메뉴 항목 위로 마우스 올렸을 때 스타일 */
     background:#ebebeb;  /* 배경색 */
     color:#444;  /* 글자색 */
     text-shadow: 0 1px 1px rgba(255,255,255,1);  /* 글자 그림자 */
     border-radius:1.4em; /* 모서리 둥글게 */
     -webkit-box-shadow:0 1px 1px rgba(0,0,0,0.2);  /* 메뉴 항목에 그림자 */
     -moz-box-shadow:0 1px 1px rgba(0,0,0,0.2);  /* 메뉴 항목에 그림자 */
  }

  #nav ul {  /* 서브 메뉴 영역에 대한 스타일 */
     margin:0; /* 서브 메뉴 바깥 여백 없음 */
     padding:0; /* 서브 메뉴 안여백 없음 */
     list-style:none; /* 목록의 불릿 없앰 */
     position: absolute; /* 고정 위치에 표시 */
     left: 0; /* 부모 요소와 left 좌표 값은 같게 */
     top:45px;  /* 부모 요소로부터 아래로 45px 밑에 표시 */
     width: 150px; /* 서브 메뉴 너비 */
     background:#ddd;  /* 서브 메뉴 배경색 */
     border:1px solid #b4b4b4;  /* 서브 메뉴 테두리를 그림 */
     border-radius:8px;  /* 모서리를 둥글게 처리 */
     box-shadow:0 1px 3px rgba(0,0,0,.3);
     opacity: 0; /* 투명하게 표시 - 결국 평소엔 안보임 */
  }

  #nav ul li { /* 서브 메뉴 각 항목의 스타일 */
     float: none; /* 세로로 표시 */
     margin:0;   /* 바깥 여백 없음 */
     padding:0;  /* 안 여백 없음 */
     height:0;  /* 화면에서 감춤 */
     overflow:hidden; /* height:0을 해도 보이는 부분이 있다면 감춤 */
  }
  
   #nav li:hover  ul { /* 메인 메뉴 위로 마우스 오버했을 때 서브 메뉴 스타일 */
   opacity: 1; /* 서브 메뉴 불투명해짐 -> 화면에 보임 */
  }

  #nav li:hover ul li {
   height:35px;  /* 서브 메뉴 항목의 높이 */
   overflow:visible; /* 메뉴 영역을 넘어서는 내용이 있다면 표시 */
   padding:0; /* 안여백 없음 */
  }
    
  #nav ul a {  /* 서브 메뉴 항목의 링크 스타일 */
     font-weight:normal;  /* 진하기 보통으로 */
     text-shadow:0 1px 0 #fff;  /* 글자 그림자 */
     color:#333;   /* 글자색 */
  }
  #nav ul li:hover  > a { /* 서브 메뉴 항목 위로 마우스 오버했을 때의 스타일 */
     background:#0078ff;  /* 배경색 */
     color:#fff;   /* 글자색 */
     text-shadow:0 1px 1px rgba(0,0,0,0.1);  /* 글자 그림자 */
     border-radius:0;  /* 모서리 둥글게 처리 안함 */
  }
  #nav ul li:first-child > a{  /* 서브 메뉴 첫번째 항목의 스타일 */
     border-top-left-radius:8px;   /* 왼쪽 윗부분 둥글게 */
     border-top-right-radius:8px;   /* 오른쪽 윗부분 둥글게 */
  }
  #nav ul li:last-child > a {  /* 서브 메뉴 마지막 항목의 스타일 */
     border-bottom-left-radius:8px;   /* 왼쪽 아랫부분 둥글게 */
        border-bottom-right-radius:px;     /* 오른쪽 아랫부분 둥글게 */
  }
 /********************************************************************************************/ 
 
 
 /*******************************페이지 나누는 css설정*************************************/
#div_root{ /* 전체 */
margin-top: 5px;
margin-left: 20px;
margin-right: 5px;
margin-bottom: 5px;
width:1200px;
}
#div_top{ /*사진/배너 */
width:120%;
height:200px;
background:url('/TastyPangyo_bak/2.jpg') no-repeat ;   /*2.jpg(음식사진)을 경로에 넣어서 바꿔줘야함*/
background-size:cover;
text-align:center;
font-family : '굴림';
font-size:3em; color:white;
border-width:medium;
}
#div_menu{ /*메뉴바 */
width:120%;
height:50px;
float:left;
backgroud-color:#819FF7;
text-align:left;
}
#div_con{  /* 내용칸 */
width:120%;
height:700px;
float:left;
background-color:;
text-align:left;
}
#div_bottom{  /* 소개칸 */
width:120%;
height:50px;
clear:both;
background-color:;
text-align:center;
border-top-width: 2px;
}

/************************************* P태그 ID CSS설정 ****************************** */
#p1{ 
    border-color:black;  
   border-style:solid;  
   padding : 10px;
   border-top-width:5px;
   border-right-width:0;
   border-bottom-width:5px;
   border-left-width:0;
}
/****************************************************************************************/

/*****************************맛집 TOP5, 별점 TOP5 CSS 설정****************************/
.content1{
   width:100%;
   height:310px;
   border:1px solid black;
   background:lightyellow;   
   padding:5px;                 /* 네 방향의 패딩 모두 5px */
}
.content2{
   width:100%;
   height:310px;
   border:1px solid black;
   background:lightyellow;   
   padding:5px;              /* 네 방향의 패딩 모두 5px */
}

.con_td {
 text-align: center;
 width: 280px;
 height: 220px;
 padding-left: 20px;
 padding-right: 20px;
 border-color:black;
 border:1;
 background-color: white;

}
/*****************************************************************************************/
</style>
</head>

<!--------------------------------- BODY 대신 DIV 사용------------------------------------------>
<div id="div_root"> 


<!----------------------------------그림있는 상단 설정------------------------------------------->
<div id="div_top"><h1>Tasty Pangyo</h1></div>


<!-------------------------------------메뉴바 설정----------------------------------------------->
<div id="div_menu">
<ul id="nav">
   <li><a href="/TastyPangyo/jsp/main.jsp"> 처음으로 </a></li>
  <li><a href="/TastyPangyo/rastaurant/select_restaurant.jsp"> 전체맛집조회 </a></li>
   <li><a href=""> 건물로조회</a></li>
   <li><a href="#"> 이름으로조회 </a></li>  
   <li><a href="#"> 카테고리로조회</a></li>
  
   
   <li><form action="/TastyPangyo/login" method="post">
   <c:choose>
      <c:when test="${empty sessionScope.id }">
         ID : <input type="text" name="id" placeholder="id를 입력하세요" required oninvalid="setCustomValidity('ID를 입력해주세요!')" oninput="setCustomValidity('')">
         PW : <input type="password" name="pw" placeholder="비밀번호를 입력하세요" required oninvalid="setCustomValidity('비밀번호를 입력해주세요!')" oninput="setCustomValidity('')">      
               <input type="submit" value="확인"> 
       <li><a href="/TastyPangyo/member/join_form.jsp">회원가입</a></li>
   </c:when>
   <c:otherwise>
      <%= session.getAttribute("id") %>님 환영합니다.&nbsp
      <a href="/TastyPangyo/logout">로그아웃</a>&nbsp
      <a href="/TastyPangyo/member/myPage.jsp">마이페이지</a>
      <c:if test="${sessionScope.id == 'admin' }">
         <a href="/TastyPangyo/member/memberSelect.jsp">관리모드</a>
      </c:if>      
   </c:otherwise>
   </c:choose>'
   </form></li>            
</ul>
</div><br><br><br><br>

<!---------------------------------------내용 설정-------------------------------------------->
<div id="div_con">
   <div class="content1">
      <h3> 맛집 TOP 5</h3>
      <table> 
		<tr>
			<c:forEach items="${ applicationScope.hitsTop5 }" var="hitsTop5">
				<td class="con_td">
				<!-- top 5 별점 조회수 -->
				${ hitsTop5.restaurantName }<br>
				${ hitsTop5.foodCategory }<br>
				${ hitsTop5.location }<br>
				${ hitsTop5.hits }<br>
				<img src="${ initParam.rootPath }/image_up/KakaoTalk_20170411_141408401.jpg" width="100px"><br>
				<a href="/TastyPangyo/restaurant/selectResById" >바로가기</a>
				
				</td>
			</c:forEach>
		</tr>
	 </table>
   </div><br>
   <div class="content2">
      <h3> 별점 TOP 5</h3>
      <table>
		<tr>
			<c:forEach items="${ applicationScope.kostarTop5 }" var="kostarTop5">
				<td class="con_td">
				<!-- top 5 별점 조회수 -->
				${ kostarTop5.restaurantName }<br>
				${ kostarTop5.foodCategory }<br>
				${ kostarTop5.location }<br>
				${ kostarTop5.hits}<br>
				<%-- ${ hitsTop5.AVG(kostar) }<br> --%>
				<%-- ${ kostarTop5.images[1] } --%>
				
				</td>
			</c:forEach>
		</tr>
	</table>
     </div> 
</div>


<!---------------------------------------소개 내용---------------------------------------------->
<div id="div_bottom"><p id="p1">Tasty Pangyo 경기 성남시 분당구 대왕판교로 660  www.kosta.or.kr<br>
                              대표이사 서현화   대표전화 02-XXXX-XXXX               </p>
                     
                  
</div>
</div>



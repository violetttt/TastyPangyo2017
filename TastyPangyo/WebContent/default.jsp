<%@ page contentType="text/html;charset=utf-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!-- 
127.0.0.7:8088/TastyPangyo로 접속했을때 default.jsp가 기본을 실행되게 wep.xml에 설정
-> TastyPangyoServlet으로 바로 이동하도록 forward 사용!
 -->
<jsp:forward page="/index"/>
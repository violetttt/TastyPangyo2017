<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<form action="/TastyPangyo/updateRes" method="post">
		
		맛집 ID : <input type = "text" name="resId"><br><br>
		
		맛집 이름 : <input type = "text" name="resName"><br><br>
		
		전화번호 : <input type="text" name="resTelNum"><br><br>
		
		맛집 위치 :<br> 삼환하이펙스A<input type = "radio" name="location" value="삼환하이펙스A" ><br>
				   삼환하이펙스B<input type = "radio" name="location" value="삼환하이펙스B" ><br>
				   유스페이스1<input type = "radio" name="location" value="유스페이스1"><br>
				   유스페이스2<input type = "radio" name="location" value="유스페이스2" ><br>
				  H스퀘어<input type = "radio" name="location" value="H스퀘어" ><br><br>
		
		음식 종류 : 한식<input type = "radio" name="foodCategory" value="한식" ><br>
				   양식<input type = "radio" name="foodCategory" value="양식" ><br>
				   중식<input type = "radio" name="foodCategory" value="중식"><br>
				   일식<input type = "radio" name="foodCategory" value="일식" ><br>
				  기타<input type = "radio" name="foodCategory" value="기타" ><br><br>
		
		맛집 메뉴 : <textarea rows="10" cols="30" name="menu"></textarea><br><br>
		
		맛집 소개 : <textarea rows="10" cols="30" name="introduction"></textarea><br><br>	
		<p>
		<input type="submit" value="변경"> 		
		</form>
	
	
	
	</center>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{text-align:center;}
body{text-align:center;}
fieldset{text-align:center;}


</style>
</head>
<body>

<h1>이미지를 집어 넣어보자!</h1>
<form action="${initParam.rootPath}/tp/imageupload" method="post" enctype="multipart/form-data">
		<legend>무슨 사진을 집어 넣을껀데?</legend>
		<input type="file" name="image" multiple width="100"> 
		<input type="submit" value="전송"><br>
</form>


</body>
</html>
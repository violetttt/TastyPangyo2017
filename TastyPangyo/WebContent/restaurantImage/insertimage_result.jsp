<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{text-align:center;}
</style>
</head>
<body>
<h1>업로드 짜긴 했는데 되려나</h1>

<form action="${initParam.rootPath}/tp/imageupload" method="post" enctype="multipart/form-data">
<h2>사진 더 넣어 보자</h2> <input type="file" name="image"><input type="submit" value="전송"><br><br>
</form>

<h2>나와라 이미지들아 제발</h2><br>


<c:forEach items="${ requestScope.result }" var="name">
		<form action="${initParam.rootPath}/tp/imagedelete" method="post">
		<input type="hidden" name="name" value="${name}"> 
		<img src="${initParam.rootPath }/up_images/${name}" width="300px"><input type="submit" value="삭제">
		</form>
</c:forEach>

<!-- 사진 삭제 -->
<form action="${initParam.rootPath}/tp/imagedelete" method="post">
	<input type="submit" value="전체 사진 삭제"><br>
</form>

</body>
</html>
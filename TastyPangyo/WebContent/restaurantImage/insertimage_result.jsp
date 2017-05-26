<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{text-align:center;}
body{text-align:center;}

</style>
</head>
<body>
<!-- 결과 -->
<c:choose>
<form action="${initParam.rootPath}/tp/imageupload" method="post" enctype="multipart/form-data">
<fieldset style="width:340px; height:px;  border:1px solid #ff6666;">
<legend>사진 더 넣어 보자</legend>
<input type="file" name="image" multiple><input type="submit" value="전송"><br><br>
</fieldset>
</form>

</c:choose>

<!-- 삭제  -->
<c:forEach items="${ requestScope.result }" var="name">
		<form action="${initParam.rootPath}/tp/imagedelete" method="post">
<p>
		<input type="hidden" name="name" value="${name}"> 
		<img src="${initParam.rootPath }/up_images/${name}" width="100px"><input type="submit" value="삭제">
</p>
		</form>
</c:forEach>



<!-- 사진 삭제 -->
<form action="${initParam.rootPath}/tp/imagedelete" method="post">
	<input type="submit" value="전체 사진 삭제"><br>
</form>

</body>
</html>
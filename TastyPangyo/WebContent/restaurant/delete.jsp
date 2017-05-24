<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(request.getAttribute("errorMessage")!=null){%>
	<span style = "color:red;">
	<%=request.getAttribute("errorMessage") %>
	</span>
	<%} %>
</body>
</html>
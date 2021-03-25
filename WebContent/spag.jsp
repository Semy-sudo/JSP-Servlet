<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ----------------------------------------------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
pageContext.setAttribute("result", "hello");
%>
<body>
	${requestScope.result}</br>
	${names[0]}</br>
	${notice.id}</br>
	${notice.title}</br>
	${result}</br>
	${param.n gt 3}</br>
	${header.accept }
</body>
</html>
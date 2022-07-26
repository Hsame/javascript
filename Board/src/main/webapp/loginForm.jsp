<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
</head>
<body>
<%
	String msg = (String) request.getAttribute("msg");
	if(msg != null) {
		out.print("<p>" + msg + "</p>");
	}
%>
	<form action="login.jsp" method='post'>
	ID : <input type="text" name ="id"><br>
	PW : <input type="password" name="pwd"><br>
	<input type="submit" value="로그인">
	</form>

</body>
</html>
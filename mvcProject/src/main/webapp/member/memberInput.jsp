<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="memberProc.jsp" method="post">
		
		아이디: <input type="text" name="id"><br>
		비밀번호: <input type="password" name="passwd"><br>
		이름: <input type="text" name="name"><br>
		메일: <input type="email" name="mail"><br>	
		
		<input type="submit" value="회원가입"><br>
	</form>
</body>
</html>
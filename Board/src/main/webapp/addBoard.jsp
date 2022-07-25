<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addBoard.jsp</title>
</head>
<body>
<form action="insertBoard.jsp" method="post">
글제목 : <input type="text" name="title"><br>
글내용 : <textarea name="content" col="30" rows="3"></textarea><br>
작성자 : <input type="text" name = "writer"><br>
<input type="submit" value="등록">
</form>

</body>
</html>
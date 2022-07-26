<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addBoard.jsp</title>
</head>
<body>
<form action="insertBoard.jsp" method="post">
<%
/* request.setCharacterEncoding("utf-8");
String user = (String) session.getAttribute("loginId");
if(user == null || user.equals("")) {
	response.sendRedirect("loginForm.jsp");
} */
%>

<c:set var="user" value="${loginId }"></c:set>
<c:if test="${empty user }">
	<c:redirect url="loginForm.jsp"></c:redirect>
</c:if>

글제목 : <input type="text" name="title"><br>
글내용 : <textarea name="content" col="30" rows="3"></textarea><br>
작성자 : <input type="text" name = "writer" value="${user}" readonly><br>
<input type="submit" value="등록">
</form>

</body>
</html>
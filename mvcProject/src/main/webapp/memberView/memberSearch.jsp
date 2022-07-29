<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> SEARCH MEMBER INFO </title>
</head>
<body>
	
	<h3> 회원검색(조회) 화면</h3>
	
	<form action="${pageContext.request.contextPath}/memberSearch.do" method="post">
		아이디:<input type="text" name="id">
		<input type="hidden" name="job" value="search">
		<input type="submit" value="회원 검색">
	</form>
	<p>${error}</p>
	
</body>
</html>
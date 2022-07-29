<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Member Search Output Page</title>
</head>
<body>
	
	<c:if test="${empty member }">
		<p><h3>검색결과가 없습니다</h3></p>
	</c:if>
	
	<p>${member}</p>
	<jsp:include page="home.jsp"></jsp:include>
	
</body>
</html>
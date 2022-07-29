<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER DELETE PAGE</title>
</head>
<body>

	<h3></h3>
	<form action="${pageContext.request.contextPath}/memberSearch.do" method="post">
		아이디 : <input type="text" name="id"><br> 
		<input type="hidden" name="job" value="delete"> 
		<input type="submit" value="조회">
	</form>
	<p>${error}</p>
	
	<c:set var="vo" value="${member}" />
	<c:choose>	
		<c:when test="${!empty member }">
			<form action="${pageContext.request.contextPath}/memberDelete.do" method="post">
	            아이디 : <input type="text" name="id" value="${vo.id }" readonly ><br>
	            비밀번호 : <input type="text" name="passwd" value="${vo.passwd }" readonly><br>
	            이름 : <input type="text" name="name" value="${vo.name }" readonly><br>
	            이메일 : <input type="text" name="mail" value="${vo.mail }" readonly><br>
            <input type="submit" value="삭제">
         </form>		
		</c:when>
		
		<c:otherwise>
		  <p>${error}</p>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원목록 페이지</h3>

	<table border="1">		
		<tr><th>아이디</th> <th>이름</th> <th>이메일</th> <th>비밀번호</th></tr>
			<c:forEach var="i" items="${list}">
				<tr>
					<td>${i.id}</td>
					<td>${i.name}</td>
					<td>${i.mail}</td>
					<td>${i.passwd}</td>		
				</tr>
			</c:forEach>	
	</table>
	<jsp:include page="home.jsp"></jsp:include>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Member Update Page</title>
</head>
<body>
	
	<h3> 회원검색(수정) 화면</h3>
	
	<form action="${pageContext.request.contextPath}/memberSearch.do" method="post">
      아이디 : <input type="text" name="id"><br>
      <input type="hidden" name="job" value="update">
      <input type="submit" value="조회">
	</form>

	<c:set var="vo" value="${member}" />
   <c:choose>
      <c:when test="${!empty vo }">
         <form action="${pageContext.request.contextPath}/memberUpdate.do"" method="post">
            아이디 : <input type="text" name="id" value="${vo.id }" readonly ><br>
            비밀번호 : <input type="text" name="passwd" value="${vo.passwd }"><br>
            이름 : <input type="text" name="name" value="${vo.name }"><br>
            이메일 : <input type="text" name="mail" value="${vo.mail }"><br>
            <input type="submit" value="수정">
         </form>
      </c:when>
      
      <c:otherwise>
         <p>${error}</p>
      </c:otherwise>
   </c:choose>
	

</body>
</html>
<%@page import="com.tst.board.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/example01.jsp</title>
</head>
<body>
<%
	request.setAttribute("user_id", "Hong");
	UserVO vo = new UserVO();
	vo.setId("user1");
	vo.setPasswd("1111");
	vo.setName("사용자1");
	request.setAttribute("user", vo);
	
	//request.getParameter("id");  ${param.id }
	//request.getParameter("pwd"); ${param.pwd }
%>
	Literal : &{"Literal"}
	<br> Operator : ${5>3 }
	<br> Object : ${header.host }
	<br> IfCondition: ${5>3 ? "true" : "false"}
	<br> Context : ${pageContext.servletContext.contextPath }
	<br> UserId : ${user_id }
	<br> VO: ${user.id }, ${user.passwd }, ${user.name }
	<br> ${empty user ? "값이 없습니다." : user }
	<br> ID : ${param.id }, PWD : ${param["pwd"] }
	
</body>
</html>
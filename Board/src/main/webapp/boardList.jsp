<%@page import="java.util.List"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
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
	<%
/* 	String id = (String) session.getAttribute("loginId");
	if (id != null) {
		out.print("<h3>" + id + "님으로 로그인 되었습니다.<br>");
		out.print("<a href='logout.jsp'>로그아웃</a>");
	} else {
		out.print("<h3>손님입니다.</h3>");
	} */
	%>
	<c:choose>
		<c:when test="${!empty loginId }">
		<h3><c:out value="${loginId}"></c:out>님으로 로그인했습니다</h3>
		</c:when>
		<c:otherwise>손님으로 접속하였습니다.</c:otherwise>
	</c:choose>

	<table border='1'>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>방문횟수</th>
		</thead>
		<tbody>

			<%
			request.setCharacterEncoding("utf-8");
			BoardDAO dao = new BoardDAO();
			List<BoardVO> list = dao.boardList();

			//for (BoardVO vo : list) {
			%>

			<c:set var="boards" value="<%=list%>"></c:set>
			<c:forEach var="vo" items="${boards }">
				<tr>
					<td><a href="boardDetail.jsp?id=${vo.boardId }">${vo.boardId }</a></td>
					<td>${vo.title }</td>
					<td>${vo.writer }</td>
					<td>${vo.createDate }</td>
					<td>${vo.cnt }</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<a href="addBoard.jsp">글작성</a>
</body>
</html>
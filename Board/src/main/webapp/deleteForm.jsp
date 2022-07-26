<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm.jsp</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String bno = request.getParameter("bno");
BoardDAO dao = new BoardDAO();
BoardVO vo = dao.getBoard(Integer.parseInt(bno));
%>

<form action="delete.jsp">
<table>
<tr>
<th><p><%=vo.getBoardId() %> 번 게시물을 를 삭제하시겠습니까?</p>
<input type ="hidden" name="bid" value= "<%= vo.getBoardId()%>"></th>
</tr>
<tr><th><input type="submit" value="삭제"></th></tr>
</table>
</form>

</body>
</html>
<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>
	<%	request.setCharacterEncoding("utf-8");
		String bno = request.getParameter("bno");
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(Integer.parseInt(bno));
	%>
	<form action="update.jsp">
	<table border="1">
	<tr>
	<th>글번호</th>
	<td><input type="text" name="bid" value= "<%= vo.getBoardId()%>" readonly></td>
	</tr>
	<tr>
	<th>제목</th>
	<td><input type="text" name="btitle" value= "<%= vo.getTitle()%>"></td>
	</tr>
	<tr>
	<th>내용</th>
	<td><input type="text" name="bcontent" value= "<%= vo.getContent()%>"></td>
	</tr>
	<tr>
	<th>작성자</th>
	<td><p><%= vo.getWriter()%>
	<input type="hidden" name="bwriter" value= "<%= vo.getWriter()%>">	
	</p></td>
	</tr>
	</table>
	<input type="submit" value="수정">
	</form>
	</body>
</html>
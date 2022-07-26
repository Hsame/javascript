<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("bid");
String title = request.getParameter("btitle");
String content = request.getParameter("bcontent");

BoardVO vo = new BoardVO();
vo.setBoardId(Integer.parseInt(id));
vo.setTitle(title);
vo.setContent(content);


BoardDAO dao = new BoardDAO();
dao.updateBoard(vo);

response.sendRedirect("boardList.jsp");
%>
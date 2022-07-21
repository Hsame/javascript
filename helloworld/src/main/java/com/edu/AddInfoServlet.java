package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddInfoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<h3> 추가적인 정보</h3>");
		out.print("<p> Request Method" + req.getMethod()+"</p>");
		out.print("<p> Path Info" + req.getPathInfo()+"</p>");
		out.print("<p> Reqiest Translated" + req.getPathTranslated()+"</p>");
		out.print("<p> Request String" + req.getQueryString()+"</p>");
		out.print("<p> Request Length" + req.getContentLength()+"</p>");
		out.print("<p> Request Type" + req.getContentType()+"</p>");
		out.close();
	}
}

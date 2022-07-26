package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatch2")
public class DispatchTest2Servlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");		
		
		String title = (String) req.getAttribute("param1");
		String auth = (String) req.getAttribute("param2");
		String publ = (String) req.getAttribute("param3");

		resp.getWriter().print("<h3>Dispatch page 2</h3>");
		resp.getWriter().print("책제목 : " + title + "<br>");
		resp.getWriter().print("책저자 : " + auth + "<br>");
		resp.getWriter().print("출판사 : " + publ + "<br>");
	}

}

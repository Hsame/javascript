package com.tst.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatch1")
public class DispatchTest1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		resp.getWriter().print("<h3>Dispatch page 1</h3>");
		
		String title = req.getParameter("title");
		String authr = req.getParameter("author");
		String publi = req.getParameter("publish");
		
		req.setAttribute("param1", title);
		req.setAttribute("param2", authr);
		req.setAttribute("param3", publi);
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/dispatch2");
		rd.forward(req, resp); //dispatch2 요청 재지정;
		//rd.include(req, resp);
		
	}
}

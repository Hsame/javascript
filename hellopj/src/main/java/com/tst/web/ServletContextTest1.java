package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context1")
public class ServletContextTest1 extends HttpServlet{
	ServletContext sc;
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		sc = config.getServletContext(); //ServletConfig 객체.
		System.out.println(sc);
		
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loc = sc.getInitParameter("contextConfigLocation");
		resp.getWriter().print("Location : " + loc + "\n");
		
		String con = sc.getInitParameter("contextConfig");
		resp.getWriter().print("Config :" + con);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String enc = sc.getInitParameter("encoding");
		System.out.println(enc);
		
		req.setCharacterEncoding(enc);
		resp.setCharacterEncoding(enc);
		resp.setContentType("text/html; charset=utf-8");
		
		String name = req.getParameter("name");
		System.out.println(name);
		resp.getWriter().print("이름 : " + name);
	}
}

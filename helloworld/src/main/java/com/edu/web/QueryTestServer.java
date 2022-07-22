package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/queryTest")
public class QueryTestServer extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("id"); // parameter : id 값을 반환
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduce = req.getParameter("introduce");

		out.print("<h3> 입력받은 값</h3>");
		out.print("<p>ID : " + id + "</p>");
		out.print("<p>비밀번호 : " + pwd + "</p>");
		out.print("취미 : <ul>");

		for (String hob : hobby) {
			out.print("<li>" + hob + "</li>");
		}
		out.print("</ul>");
		out.print("<p>이름 : " + name + "</p>");
		out.print("<p>성별 : " + gender + "</p>");
		out.print("<p>종교 : " + religion + "</p>");
		out.print("자기소개 : " + introduce + "</p>");
		out.print("질의문자열 : " + req.getQueryString());
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

//		String id = req.getParameter("id"); // parameter : id 값을 반환
//		String pwd = req.getParameter("pwd");
//		String name = req.getParameter("name");
//		String[] hobby = req.getParameterValues("hobby");
//		String gender = req.getParameter("gender");
//		String religion = req.getParameter("religion");
//		String introduce = req.getParameter("introduce");
//
//		out.print("<h3> 입력받은 값</h3>");
//		out.print("<p>ID : " + id + "</p>");
//		out.print("<p>비밀번호 : " + pwd + "</p>");
//		out.print("취미 : <ul>");
//		for (String hob : hobby) {
//			out.print("<li>" + hob + "</li>");
//		}
//		out.print("</ul>");
//		out.print("<p>이름 : " + name + "</p>");
//		out.print("<p>성별 : " + gender + "</p>");
//		out.print("<p>종교 : " + religion + "</p>");
//		out.print("자기소개 : " + introduce + "</p>");
		
		ServletInputStream sis = req.getInputStream(); // post : 입력스트림.
		int len = req.getContentLength(); //데이터 크기
		byte[] buf = new byte[len];
		sis.readLine(buf, 0, len);
		
		String queryString = new String(buf);
		out.print("질의문자열 : " + queryString);
		sis.close();
		out.close();
	}
}

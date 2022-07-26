package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if (id.isEmpty() || pwd.isEmpty()) {
			out.print("ID와 비밀번호를 입력해주세요");
			return;
		}
		HttpSession session = req.getSession();
		if(session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			out.print("로그인을 완료했습니다");
		} else {
			out.print("현재 로그인 중입니다.");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("id") != null) {
			session.invalidate();
			out.print("로그아웃 완료했습니다.");
		} else {
			out.print("현재 로그인상태가 아닙니다");
		}
	}

}

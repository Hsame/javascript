package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.ShareObject;

@WebServlet("/context3")
public class ServletContextTest3 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		
		ShareObject obj1 = new ShareObject();
		obj1.setCount(100);
		obj1.setStr("객체 공유 테스트");
		
		ShareObject obj2 = new ShareObject();
		obj2.setCount(200);
		obj2.setStr("객체 공유 테스트2");
		
		sc.setAttribute("data", obj1);
		sc.setAttribute("data2", obj2);
		
		resp.getWriter().print("ServletContext object add.");
	}


}

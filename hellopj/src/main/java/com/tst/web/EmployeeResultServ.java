package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.Employee;

@WebServlet ("/empResult")
public class EmployeeResultServ extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		List<Employee> list = (List<Employee>) req.getAttribute("data"); //list
		
		PrintWriter out = resp.getWriter();
		for (Employee emp : list) {
			out.print("사원번호 : " + emp.getEmployeeId() + ", 사원 이름 : " + emp.getFirstName());
		}
	}

}

package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third.do")
public class ThirdServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청정보 :
		resp.setContentType("text/html; charset=utf-8");
		String value = req.getParameter("key");
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpInfo(value);

		PrintWriter out = resp.getWriter();

		out.print("<table border ='1'>");
		out.print("<thead>" + "<tr>" + "<th>사원번호</th>" + "<th>성씨</th>" + "<th>이름</th>" + "<th>이메일</th>" + "<th>급여</th>"
				+ "</tr>" + "</thead>");
		out.print("<tbody>");
		for (Employee emp : list) {
			out.print("<tr>" + "<td>" + emp.getEmployeeId() + "</td>" + "<td>" + emp.getLastName() + "</td>" + "<td>"
					+ emp.getFirstName() + "</td>" + "<td>" + emp.getEmail() + "</td>" + "<td>" + emp.getSalary()
					+ "</td>" + "</tr>");
		}
		out.print("</tbody>");
		out.print("</table>");
	}

}

package com.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO{
	
	//변경
	public void updateMember(String name, String pass, String role) {
		String sql = "update members "
					+"set member_passwd = ?, "
					+ "member_role = ? "
					+ "where member_id = ?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, role);
			pstmt.setString(3, name);
			
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	//user_name, user_pass, role => 입력
	public void insertMember(String name, String pass, String role) {
		String sql = "insert into members values (?,?,?)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			pstmt.setString(3, role);
			
			int r = pstmt.executeUpdate(); //update,insert,delete 일때 사용
			System.out.println(r + "건 입력됨");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public List<Employee> getEmpInfo(String name) {
		String sql = "select * from employees where first_name=?";
		connect();
		List<Employee> list = new ArrayList<>();
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Employee emp = new Employee();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setSalary(rs.getInt("salary"));
			
			list.add(emp);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	public List<Employee> getEmpList() {
		List<Employee> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select employee_id,first_name, email, hire_date, salary, job_id from employees");
		while (rs.next()) {
			Employee emp = new Employee();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setEmail(rs.getString("email"));
			emp.setHiredate(rs.getString("hire_date"));
			emp.setSalary(rs.getInt("salary"));
			emp.setJobId(rs.getString("job_id"));
			
			list.add(emp);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}

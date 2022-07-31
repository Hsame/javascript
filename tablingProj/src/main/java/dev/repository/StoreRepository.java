package dev.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import dev.domain.Store;

public class StoreRepository {
	
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
		
	public void connect() {		
		try {
			InitialContext ic = new InitialContext(); // Server.xml에 등록해준 Resource를 가져오기 위해서 사용한다.
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			// Tomcat 일 경우 java:comp/env/[Resource Name]
			
			conn = ds.getConnection(); // ds에 있는 값으로다가 만들어져있는 커넥션을 가져온다!
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		}catch(SQLException e) {
			System.out.println("DB 접속 해제 실패!");
			e.printStackTrace();
		}		
	}
	
	public List<Store> getList() {
		List<Store> list = new ArrayList<>();
		String sql = "select store_name, store_address, telephone, AVAILABLE_TIME, food_category from stores where APPROVAL_STATUS = 0";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Store st = new Store();
				
				st.setStoreName(rs.getString("store_name"));
				st.setStoreAddress(rs.getString("store_address"));
				st.setTelephone(rs.getString("telephone"));
				st.setAvailableTime(rs.getString("AVAILABLE_TIME"));
				st.setFoodCategory(rs.getString("food_category"));
				
				list.add(st);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public boolean deleteStore(String store_name) {
		String sql = "delete stores where store_name = ?";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, store_name);
			
			int result = pstmt.executeUpdate();
			System.out.println(result + " 건이 거절되었습니다.");
			 if (result > 0) {
				 return true;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
	}

	public boolean updateStore(String store_name) {
		String sql = "UPDATE stores SET approval_status = 1 where store_name= ?";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, store_name);
			
			int result = pstmt.executeUpdate();
			System.out.println(result + " 건 등록되었습니다");
			
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return false;
	}
	
	public List<Store> getacceptList() {
		List<Store> list = new ArrayList<>();
		String sql = "select store_name, store_address, telephone, AVAILABLE_TIME, food_category from stores where APPROVAL_STATUS = 1";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Store st = new Store();
				
				st.setStoreName(rs.getString("store_name"));
				st.setStoreAddress(rs.getString("store_address"));
				st.setTelephone(rs.getString("telephone"));
				st.setAvailableTime(rs.getString("AVAILABLE_TIME"));
				st.setFoodCategory(rs.getString("food_category"));
				
				list.add(st);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}

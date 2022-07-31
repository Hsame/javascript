package co.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.dev.vo.MemberVO;

public class MemberDAO {

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
	
	public void insertMember(MemberVO vo) {
		try {
			connect();
			String sql = "INSERT INTO member(id, name, passwd, mail) "
					   + "VALUES(?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getMail());

			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건을 입력했습니다");
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
	}
	
	public List<MemberVO> getList(){		
		List<MemberVO> list = new ArrayList<>();
		String sql = "SELECT * FROM member order by 1";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("mail"));
				
				list.add(vo);				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
		
		return list;
	}
	
	public MemberVO searchMember(String id) {		
		MemberVO vo = null;		
		String sql = "SELECT * FROM member WHERE id = ?";		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				vo = new MemberVO();
				
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("mail"));
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
		
		return vo;		
	}
	
	public void updateMember(MemberVO vo) {		
		String sql = "UPDATE member SET passwd = ?, name = ?, mail = ? WHERE id = ?";	
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);			
			
			pstmt.setString(1, vo.getPasswd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getMail());
			pstmt.setString(4, vo.getId());			
			
			int result = pstmt.executeUpdate();			
			System.out.println("정상적으로 " + result + "건이 수정되었습니다");			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
	}
	
	public boolean deleteMember(String id) {
		String sql = "DELETE member WHERE id = ?";	
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();			
			System.out.println("정상적으로 " + result + "건이 삭제되었습니다");			
			if (result > 0 ) {
			return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
		return false;
	}
	
	
}

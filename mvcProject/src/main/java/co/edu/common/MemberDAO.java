package co.edu.common;

import java.sql.SQLException;

public class MemberDAO extends DAO{
	
	//입력처리
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
	
	
	
	
	
}

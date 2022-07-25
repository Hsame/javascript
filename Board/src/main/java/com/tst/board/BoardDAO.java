package com.tst.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tst.common.DAO;

public class BoardDAO extends DAO {
	
	//등록
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board values((select nvl(max(board_id),0)+1 from board), ?, ?, ?,sysdate,0)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력.");;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	//목록
	   public List<BoardVO> boardList(){	
		   
	      List<BoardVO> list = new ArrayList<>();
	      String sql = "SELECT * FROM board order by 1";   
	      
	      try {
	         connect();
	         pstmt = conn.prepareStatement(sql);

	         rs = pstmt.executeQuery();         
	         
	         while(rs.next()) {
	            BoardVO vo = new BoardVO();
	            
	            vo.setBoardId(rs.getInt("board_id"));
	            vo.setTitle(rs.getString("title"));
	            vo.setContent(rs.getString("content"));
	            vo.setWriter(rs.getString("writer"));
	            vo.setCreateDate(rs.getString("create_date"));
	            vo.setCnt(rs.getInt("cnt"));
	   
	            list.add(vo);
	         }         
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	         
	      }finally {
	         disconnect();
	         
	      }
	      
	      return list;
	   }
	   
	   //단건조회
	   public BoardVO getBoard(int boardNo) {
		   String sql = "select * from board where board_id = ?";
		   connect();
		   
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardId(boardNo);
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreateDate(rs.getString("create_date"));
				vo.setCnt(rs.getInt("cnt"));
				
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
			setCnt(boardNo);
		}
		return null;
		   
	   }
	   
	   public void setCnt(int boardNo) {
		   String sql = "update board set cnt = cnt+1 where board_id = ?";
		   connect();
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		   
	   }
}

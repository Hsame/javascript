package dev.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.domain.Member;

public class MemberRepository extends DAO{

	/*
	 * Method
	 */
	// 삽입
	public void insert(Member member) {
		String sql = "insert into members values(?, ?, ?, ?, ?)";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getMemberId());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getNickName());
			ps.setString(4, member.getPhoneNum());
			ps.setInt(5, member.getRole());

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println(result + " 건 입력.");
			} else {
				System.out.println("입력 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정
	public void update(Member member) {
		String sql = "update members set "
					+ "password = ?, "
					+ "phone_num = ?, "
					+ "nick_name = ? "
					+ "where id = ?";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getPassword());
			ps.setString(2, member.getPhoneNum());
			ps.setString(3, member.getNickName());
			ps.setString(4, member.getMemberId());

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println(result + " 건 수정.");
			} else {
				System.out.println("수정 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void delete(String id) {
		String sql = "delete from members where member_id = ?";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println(result + " 건 삭제.");
			} else {
				System.out.println("삭제 실패.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 단건조회
	public Member selectOne(String memberId) {
		Member member = null;
		String sql = "select * from members where member_id = ?";
		connect();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberId);

			rs = ps.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setPhoneNum(rs.getString(3));
				member.setNickName(rs.getString(4));
				member.setRole(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

	// 전체조회
	public List<Member> selectAll() {
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from members order by 1";
		connect();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setPhoneNum(rs.getString(3));
				member.setNickName(rs.getString(4));
				member.setRole(rs.getInt(5));

		 		list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}

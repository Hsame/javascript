package co.dev.service;

import java.util.List;

import co.dev.dao.MemberDAO;
import co.dev.vo.MemberVO;

public class MemberService {
	
	private static MemberService service = null;
	private MemberDAO dao = new MemberDAO();	
	
	private MemberService() {}	
	public static MemberService getInstance() {
		if(service == null) {
			service = new MemberService();
		}
		return service;
	}
	
	
	
	public void addMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	public List<MemberVO> memberList() {
		return dao.getList();		
	}
	
	public MemberVO getMember(String id) {
		return dao.searchMember(id);
	}
	
	public void modifyMember(MemberVO vo) {
		dao.updateMember(vo);
	}
	
	public boolean removeMember(String id) {
		return dao.deleteMember(id);
	}
	
}

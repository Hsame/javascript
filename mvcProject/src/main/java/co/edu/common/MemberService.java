package co.edu.common;


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
	
	
	//입력기능
	public void addMember(MemberVO vo) {
		dao.insertMember(vo);
	}
}

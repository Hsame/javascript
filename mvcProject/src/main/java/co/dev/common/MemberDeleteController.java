package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;

public class MemberDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("회원 삭제");
		
		String id = req.getParameter("id");		
		MemberService.getInstance().removeMember(id);
		
		req.setAttribute("id", id);
		
		Utils.forward(req, resp, "memberResult/memberDeleteOutput.jsp");
	}
	
}

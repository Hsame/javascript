package co.dev.common;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberListController implements Controller{

	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		List<MemberVO> list = MemberService.getInstance().memberList();			
		req.setAttribute("list", list);		
		
		Utils.forward(req, resp, "memberResult/memberListOutput.jsp");
	}
}

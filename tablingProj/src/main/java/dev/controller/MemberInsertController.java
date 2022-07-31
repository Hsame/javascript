package dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.Utils;
import dev.domain.Member;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String id = req.getParameter("reg_id");
		String pwd = req.getParameter("reg_pwd");
		String phoneNum = req.getParameter("reg_phone");
		String nickName = req.getParameter("reg_nickname");
		int role = Integer.parseInt(req.getParameter("reg_role"));
		

		Member member = new Member();
		member.setMemberId(id);
		// 비밀번호 암호화해서 DB 저장
		member.setPassword(memberService.encryption(pwd));
		member.setPhoneNum(phoneNum);
		member.setNickName(nickName);
		member.setRole(role);

		memberService.joinMember(member);

//		req.setAttribute("member", member);
//		
//		Utils.forward(req, resp, "memberResult/memberInsertResult.jsp");
	}

}

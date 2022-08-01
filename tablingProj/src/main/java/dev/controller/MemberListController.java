package dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dev.domain.Member;
import dev.service.MemberService;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json; charset=utf-8");
		System.out.println("MEMBERRUN");
		List<Member> list = MemberService.getMemberService().findAllMembers();
		
		JsonArray jary = new JsonArray();
		for (Member mb : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("member_id", mb.getMemberId());
			jobj.addProperty("nickname", mb.getNickName());
			jobj.addProperty("phone_num", mb.getPhoneNum());		
			if(mb.getRole() == 0) {
				jobj.addProperty("role", "관리자");
			} else if (mb.getRole() == 1) {
				jobj.addProperty("role", "점주");
			} else {
				jobj.addProperty("role", "일반회원");
			}
			jary.add(jobj);
		}
		try {
			resp.getWriter().print(jary);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

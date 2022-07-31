package dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.service.MemberService;


public interface Controller {

	MemberService memberService = MemberService.getMemberService();
	
	void execute(HttpServletRequest req, HttpServletResponse resp);
}
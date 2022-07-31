package dev.service;

import java.util.List;

import dev.domain.Member;
import dev.repository.MemberRepository;

public class MemberService {

	/*
	 * Field
	 */
	// 싱글톤
	private static MemberService memberService = new MemberService();
	MemberRepository MemberRepository = new MemberRepository();

	/*
	 * Constructor
	 */
	private MemberService() {
	}

	/*
	 * Method
	 */
	public static MemberService getMemberService() {
		return memberService;
	}

	// 회원가입
	public void joinMember(Member member) {
		MemberRepository.insert(member);
	}

	// 회원 정보 수정
	public void modifyMember(Member member) {
		MemberRepository.update(member);
	}

	// 회원 정보 삭제
	public void deleteMember(String id) {
		MemberRepository.delete(id);
	}

	// 회원 단건 조회
	public Member findOneMember(String id) {
		return MemberRepository.selectOne(id);
	}

	// 회원 전체 조회
	public List<Member> findAllMembers() {
		return MemberRepository.selectAll();
	}

	// 시저암호 - DB에 비밀번호 입력 시 암.복호화를 적용
	// 암호화
	public String encryption(String password) {
		String answer = "";
		int n = 3;

		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);

			if (Character.isLowerCase(ch)) { // 소문자
				ch = (char) ((ch - 'a' + n) % 26 + 'a');
			} else if (Character.isUpperCase(ch)) { // 대문자
				ch = (char) ((ch - 'A' + n) % 26 + 'A');
			}

			answer += ch;
		}

		return answer;
	}
	
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		String pwd = memberService.encryption("AbcD11");
		System.out.println("pwd = " + pwd);
	}

}
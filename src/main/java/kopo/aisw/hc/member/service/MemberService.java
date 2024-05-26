package kopo.aisw.hc.member.service;

import kopo.aisw.hc.member.vo.MemberVO;

public interface MemberService {
	//로그인
	public MemberVO signIn(MemberVO m) throws Exception;
	//신규회원가입
	public boolean signUp(MemberVO m);
	//기존고객 회원가입
	public boolean updateBankId(MemberVO m);
	//고객 중복확인 (중복 기준: 동일한 이름, rrn 존재하면서 bank id가 null이 아니어야 함
	public boolean humanDoubleCheck(MemberVO m);
	//아이디 중복확인
	public boolean idDoubleCheck(String userId);
	//전화번호 중복확인
	public boolean phoneDoubleCheck(String phoneNum);
	//메일 중복확인
	public boolean mailDoubleCheck(String email);
	//프로필 업데이트
	public boolean edit(MemberVO userVO);
	//프로필 조회
	public MemberVO getProfile(MemberVO userVO);
}

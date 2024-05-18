package kopo.aisw.hc.member.service;

import kopo.aisw.hc.member.vo.MemberVO;

public interface MemberService {
	public void signIn(MemberVO m) throws Exception;
	public boolean signUp(MemberVO m) throws Exception;
	public void logout() throws Exception;
}

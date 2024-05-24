package kopo.aisw.hc.member.service;

import jakarta.validation.Valid;
import kopo.aisw.hc.member.vo.MemberVO;

public interface MemberService {
	public MemberVO signIn(MemberVO m) throws Exception;
	public boolean signUp(MemberVO m);
	public boolean idDuplicationCheck(String userId);
	public boolean humanDuplicationCheck(@Valid MemberVO m);
	public boolean phoneDuplicationCheck(String phoneNum);
	public boolean mailDuplicationCheck(String email);
	public void edit(@Valid MemberVO userVO);
}

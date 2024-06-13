package kopo.aisw.hc.member.dao;

import kopo.aisw.hc.member.vo.MemberVO;

public interface MemberDAO {
	public MemberVO signIn(MemberVO m) throws Exception;
	public boolean signUp(MemberVO m);
	public boolean idDoubleCheck(String userId);
	public MemberVO humanDoubleCheck(MemberVO m);
	public boolean mailDoubleCheck(String email);
	public boolean phoneDoubleCheck(String phoneNum);
	public boolean edit(MemberVO userVO);
	public MemberVO getProfile(MemberVO userVO);
	public boolean updateBankId(MemberVO m);
	public int quitMember(MemberVO m);
	
	//임시
	public MemberVO getPwd(MemberVO m);
	public boolean checkCreditPwd(MemberVO userVO);
}

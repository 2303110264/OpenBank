package kopo.aisw.hc.member.dao;

import org.springframework.stereotype.Repository;

import jakarta.validation.Valid;
import kopo.aisw.hc.member.vo.MemberVO;

@Repository
public interface MemberDAO {
	public MemberVO signIn(MemberVO m) throws Exception;
	public boolean signUp(MemberVO m);
	public boolean idDuplicationCheck(String userId);
	public boolean humanDuplicationCheck(@Valid MemberVO m);
	public boolean mailDuplicationCheck(String email);
	public boolean phoneDuplicationCheck(String phoneNum);
}

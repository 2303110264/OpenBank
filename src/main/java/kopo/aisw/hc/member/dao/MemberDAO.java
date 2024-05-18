package kopo.aisw.hc.member.dao;

import org.springframework.stereotype.Repository;

import kopo.aisw.hc.member.vo.MemberVO;

@Repository
public interface MemberDAO {
	public void signIn(MemberVO m) throws Exception;
	public boolean signUp(MemberVO m);
	public void logout() throws Exception;
}

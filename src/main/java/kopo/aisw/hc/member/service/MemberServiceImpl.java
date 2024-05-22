package kopo.aisw.hc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kopo.aisw.hc.member.dao.MemberDAO;
import kopo.aisw.hc.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO mDao;
	
	@Override
	public void signIn(MemberVO m) throws Exception {
		mDao.signIn(m);
	}

	@Override
	public boolean signUp(MemberVO m){
		return mDao.signUp(m);
	}

	@Override
	public void logout() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean IdDuplicationCheck(String userId) {
		return mDao.IdDuplicationCheck(userId);
	}
	
}

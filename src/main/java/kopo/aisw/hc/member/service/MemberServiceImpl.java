package kopo.aisw.hc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kopo.aisw.hc.member.dao.MemberDAOImpl;
import kopo.aisw.hc.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAOImpl mDao;
	
	@Override
	public void signIn(MemberVO m) throws Exception {
		mDao.signIn(m);
	}

	@Override
	public boolean signUp(MemberVO m) throws Exception {
		return mDao.signUp(m);
	}

	@Override
	public void logout() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

package kopo.aisw.hc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import kopo.aisw.hc.member.dao.MemberDAO;
import kopo.aisw.hc.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO mDao;
	
	@Override
	public MemberVO signIn(MemberVO m) throws Exception {
		return mDao.signIn(m);
	}

	@Override
	public boolean signUp(MemberVO m){
		return mDao.signUp(m);
	}

	@Override
	public boolean idDuplicationCheck(String userId) {
		return mDao.idDuplicationCheck(userId);
	}

	@Override
	public boolean humanDuplicationCheck(MemberVO m) {
		return mDao.humanDuplicationCheck(m);
	}

	@Override
	public boolean phoneDuplicationCheck(String phoneNum) {
		return mDao.phoneDuplicationCheck(phoneNum);
	}

	@Override
	public boolean mailDuplicationCheck(String email) {
		return mDao.mailDuplicationCheck(email);
	}

	@Override
	public boolean edit(MemberVO userVO) {
		return mDao.edit(userVO);
	}

	@Override
	public MemberVO getProfile(MemberVO userVO) {
		return mDao.getProfile(userVO);
	}

	@Override
	public boolean updateBankId(MemberVO m) {
		return mDao.updateBankId(m);
	}
	
}

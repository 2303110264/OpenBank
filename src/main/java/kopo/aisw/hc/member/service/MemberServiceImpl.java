package kopo.aisw.hc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import kopo.aisw.hc.member.dao.MemberDAO;
import kopo.aisw.hc.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO mDao;
	
	@Autowired
    private PasswordEncoder passwordEncoder; // PasswordEncoder 추가
	
	/*
	@Override
	public MemberVO signIn(MemberVO m) throws Exception {
		return mDao.signIn(m);
	}
	*/
	@Override
    public MemberVO signIn(MemberVO m) throws Exception {
        MemberVO userVO = mDao.signIn(m);
        // 비밀번호 매칭 확인
        if (userVO != null && passwordEncoder.matches(m.getPassword(), userVO.getPassword())) {
            return userVO;
        }
        return null;
    }

	/*
	@Override
	public boolean signUp(MemberVO m){
		return mDao.signUp(m);
	}
	*/
	@Override
    public boolean signUp(MemberVO m){
        // 비밀번호 암호화
        m.setPassword(passwordEncoder.encode(m.getPassword()));
        return mDao.signUp(m);
    }

	@Override
	public boolean idDoubleCheck(String userId) {
		return mDao.idDoubleCheck(userId);
	}

	@Override
	public boolean humanDoubleCheck(MemberVO m) {
		return mDao.humanDoubleCheck(m);
	}

	@Override
	public boolean phoneDoubleCheck(String phoneNum) {
		return mDao.phoneDoubleCheck(phoneNum);
	}

	@Override
	public boolean mailDoubleCheck(String email) {
		return mDao.mailDoubleCheck(email);
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

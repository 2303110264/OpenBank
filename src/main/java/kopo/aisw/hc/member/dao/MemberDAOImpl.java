package kopo.aisw.hc.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kopo.aisw.hc.member.vo.MemberVO;

@Transactional
@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberVO signIn(MemberVO m) throws Exception {
		MemberVO in = sqlSession.selectOne("dao.MemberDAO.signIn", m);
		return in;
	}

	@Override
	public boolean signUp(MemberVO m) {
		try {
			sqlSession.insert("dao.MemberDAO.signUp", m);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean idDuplicationCheck(String userId) {
		MemberVO idChk = sqlSession.selectOne("dao.MemberDAO.idDuplicationCheck", userId);
		return idChk!=null;
	}

	@Override
	public boolean humanDuplicationCheck(MemberVO m) {
		if(m.getName()==null || m.getRrn()==null) return false;
		m = sqlSession.selectOne("dao.MemberDAO.humanDuplicationCheck", m);
		if(m==null) return false;
		return m.getUserId()!=null;
	}

	@Override
	public boolean mailDuplicationCheck(String email) {
		MemberVO mailChk = sqlSession.selectOne("dao.MemberDAO.mailDuplicationCheck", email);
		return mailChk!=null;
	}

	@Override
	public boolean phoneDuplicationCheck(String phoneNum) {
		MemberVO phoneChk = sqlSession.selectOne("dao.MemberDAO.phoneDuplicationCheck", phoneNum);
		return phoneChk!=null;
	}

	@Override
	public boolean edit(MemberVO userVO) {
		int i = sqlSession.update("dao.MemberDAO.updateProfile", userVO);
		return i!=0;
	}

	@Override
	public MemberVO getProfile(MemberVO userVO) {
		userVO = sqlSession.selectOne("dao.MemberDAO.profile", userVO.getCustomerId());
		return userVO;
	}

	@Override
	public boolean updateBankId(MemberVO m) {
		int i = sqlSession.update("dao.MemberDAO.updateBankId", m);
		return i!=0;
	}

}

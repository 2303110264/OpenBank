package kopo.aisw.hc.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
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
	public boolean humanDuplicationCheck(@Valid MemberVO m) {
		if(m.getName()==null || m.getRrn()==null) return false;
		m = sqlSession.selectOne("dao.MemberDAO.humanDuplicationCheck", m);
		return m.getUserId().length()>5;
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

}

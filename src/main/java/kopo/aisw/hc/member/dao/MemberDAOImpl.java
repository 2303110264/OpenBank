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
	public void signIn(MemberVO m) throws Exception {
		MemberVO in = sqlSession.selectOne("dao.MemberDAO.signIn", m);
		System.out.println(in);
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
	public void logout() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean IdDuplicationCheck(String userId) {
		MemberVO idChk = sqlSession.selectOne("dao.MemberDAO.IdDuplicationCheck", userId);
		return idChk!=null;
	}

}

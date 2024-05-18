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
		// 회원가입
		// 인데 테스트용으로 로그인을 집어넣음
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

}

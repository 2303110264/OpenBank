package kopo.aisw.hc.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kopo.aisw.hc.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void signIn(MemberVO m) throws Exception {
		MemberVO in = sqlSession.selectOne("dao.MemberDAO.login", m);
		System.out.println(in);
	}

	@Override
	public void signUp(MemberVO m) throws Exception {
		// 회원가입
		// 인데 테스트용으로 로그인을 집어넣음
		MemberVO in = sqlSession.selectOne("dao.MemberDAO.login", m);
		System.out.println(m);
		System.out.println(in);
	}

	@Override
	public void logout() throws Exception {
		// TODO Auto-generated method stub
		
	}

}

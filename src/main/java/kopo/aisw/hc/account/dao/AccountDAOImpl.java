package kopo.aisw.hc.account.dao;

import java.util.Random;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.transaction.vo.TransactionVO;

@Transactional
@Repository
public class AccountDAOImpl implements AccountDAO {
	private Random rd;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//계좌번호 생성-자동
	@Override
	public double createAccNum(int productNum) {
		StringBuilder sb = new StringBuilder();
		double accNum;
		do {
			// 은행 고정번호 3+상품번호 3 = 6자리
			sb.append(245000+productNum); 
			// random 6자리
			sb.append(rd.nextInt(900000)+100000);
			accNum = Double.parseDouble(sb.toString());
		}while(accDoubleCheck(accNum));
		return accNum;
	}

	//계좌번호 중복체크
	@Override
	public boolean accDoubleCheck(double accNum) {
		AccountVO a = sqlSession.selectOne("dao.AccountDAO.searchByAccNum", accNum);
		return a!=null;
	}

	//계좌 개설
	@Override
	public boolean openAnAccount(AccountVO account) {
		return false;
	}

	//계좌 해지
	@Override
	public boolean closeAnAccount(AccountVO account) {
		return false;
	}
	
	//입금
	public boolean deposit(double accNum, int amount) {
		return false;
	}
	
	//출금
	public boolean withdraw(double accNum, int amount) {
		return false;
	}
}

package kopo.aisw.hc.transaction.dao;

import javax.transaction.Transactional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kopo.aisw.hc.transaction.vo.TransactionVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class TransactionDAOImpl implements TransactionDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	@Transactional(rollbackOn = {Exception.class})
	public TransactionVO transfer(TransactionVO transaction) throws Exception {
		
		//transaction에 출금계좌의 afterbalance 채워야함
		if(sqlSession.insert("dao.TransactionDAO.withdraw", transaction)
				+sqlSession.insert("dao.TransactionDAO.deposit", transaction)!=2) {
			log.error("거래 실패 - "+transaction);
			throw new Exception("거래 실패. 관리자에게 문의해주세요.");
		}
		
		return transaction;
	}

	@Override
	public boolean deposit(TransactionVO transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdraw(TransactionVO transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

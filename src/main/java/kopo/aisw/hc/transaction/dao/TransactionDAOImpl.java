package kopo.aisw.hc.transaction.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kopo.aisw.hc.transaction.vo.DBTransactionVO;
import kopo.aisw.hc.transaction.vo.ViewTransactionVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class TransactionDAOImpl implements TransactionDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	@Transactional(rollbackOn = {Exception.class})
	public ViewTransactionVO transfer(ViewTransactionVO VTran) throws Exception {
		List<DBTransactionVO> transaction = vTranToDbTran(VTran);
		
		//transaction에 출금계좌의 afterbalance 채워야함
		if(sqlSession.insert("dao.TransactionDAO.withdraw", transaction.get(0))
				+sqlSession.insert("dao.TransactionDAO.deposit", transaction.get(1))!=2) {
			log.error("거래 실패 - "+VTran);
			throw new Exception("거래 실패. 관리자에게 문의해주세요.");
		}
		
		return VTran;
	}

	@Override
	public boolean deposit(DBTransactionVO dbTran) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdraw(DBTransactionVO dbTran) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DBTransactionVO> vTranToDbTran(ViewTransactionVO VTran) {
		List<DBTransactionVO> list = new ArrayList<>();
		DBTransactionVO a = new DBTransactionVO();
		// index 0=출금, 1=입금
		a.setTranType("출금");
		a.setAccNum(VTran.getWithdrawAcc());
		a.setTranName(VTran.getWithdrawName());
		a.setAmount(VTran.getAmount());
		long balance = sqlSession.selectOne("dao.AccountDAO.getBalance", VTran.getWithdrawAcc());
		a.setAfterBalance(VTran.getAfterBalance()-VTran.getAmount());
		list.add(a);
		
		a.setTranType("출금");
		a.setAccNum(VTran.getDepositAcc());
		a.setTranName(VTran.getDepositName());
		a.setAmount(VTran.getAmount());
		a.setAfterBalance(+VTran.getAmount());
		
		return null;
	}
	
}

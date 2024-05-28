package kopo.aisw.hc.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kopo.aisw.hc.account.dao.AccountDAO;
import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.transaction.vo.TransactionVO;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDAO aDao;
	
	//계좌 개설하기
	@Override
	public boolean openAnAccount(AccountVO account) {
		//계좌번호 생성-중복 체크 자동
		double accNum = aDao.createAccNum(account.getProductNum());
		account.setAccNum(accNum);
		return aDao.openAnAccount(account);
	}

	//조회: 추후 accNum 대신 accId로 변경 예정
	//계좌 조회- 이름 체크
	@Override
	public String getOwnerName(double accNum) {
		return aDao.getOwnerName(accNum);
	}
	
	//계좌 조회- 잔액 조회
	@Override
	public double getBalance(double accNum) {
		return aDao.getBalance(accNum);
	}
	
	
	//계좌 이체
	@Override
	public boolean transfer(TransactionVO transaction) {
		//잔액부족
		if(aDao.getBalance(transaction.getWithdrawAcc())-transaction.getAmount()<0)
			return false;
		//입금 또는 출금실패
		return aDao.transfer(transaction);
	}
	
	//계좌 해지하기
	@Override
	public boolean closeAnAccount(AccountVO account) {
		if(account.getBalance()!=0) return false;
		return aDao.closeAnAccount(account);
	}


}

package kopo.aisw.hc.account.service;

import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.transaction.vo.TransactionVO;

public interface AccountService {
	//계좌 개설하기
	public boolean openAnAccount(AccountVO account);

	//조회: 추후 accNum 대신 accId로 변경 예정
	//계좌 조회- 이름 체크
	public String getOwnerName(long accNum);
	//계좌 조회- 잔액 조회
	public long getBalance(long accNum);
	//계좌 이체
	public boolean transfer(TransactionVO transaction);

	//계좌 해지하기
	public boolean closeAnAccount(AccountVO account);
}

package kopo.aisw.hc.account.service;

import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.transaction.vo.TransactionVO;

public interface AccountService {
	//계좌 개설하기
	public boolean openAnAccount(AccountVO account);

	/*
	계좌 이체하기
	0. 상대 계좌 입력
	1. 상대 계좌 존재 확인하기 (없는 계좌: 일단 넘어감
						있는 계좌: 소유자 이름 출력)
	2. 이체금액 입력
	3. 차액 계산->출력
	--원래 결제비밀번호 입력해야하는데 어쩌지--
	4. 송금 => transactionVO -> 출금+입금 => 둘 다 성공해야 성공 -> 결과 출력
	*/
	//조회: 추후 accNum 대신 accId로 변경 예정
	//계좌 조회- 이름 체크
	public String getOwnerName(double accNum);
	//계좌 조회- 잔액 조회
	public double getBalance(double accNum);
	//계좌 이체
	public boolean transfer(TransactionVO transaction);

	//계좌 해지하기
	public boolean closeAnAccount(AccountVO account);
}

package kopo.aisw.hc.account.dao;

import kopo.aisw.hc.account.vo.AccountVO;

public interface AccountDAO {
	//계좌 개설- 계좌번호 생성-자동 (수동은 추후 업데이트 예정)
	public double createAccNum(int productNum);
	//계좌 개설- 생성된 계좌번호 중복체크
	public boolean accDoubleCheck(double accNum);
	//계좌 개설-등록
	public boolean openAnAccount(AccountVO account);

	//추후 accNum 대신 accId로 조회할 예정
	//계좌 조회- 이름 체크
	public String getOwnerName(double accNum);
	//계좌 조회- 잔액 조회
	public double getBalance(double accNum);
	//입금
	public boolean deposit(double accNum, int amount);
	//출금
	public boolean withdraw(double accNum, int amount);
		
	
	//계좌 해지하기
	public boolean closeAnAccount(AccountVO account);
	
}

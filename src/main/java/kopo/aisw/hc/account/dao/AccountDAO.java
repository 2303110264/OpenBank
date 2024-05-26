package kopo.aisw.hc.account.dao;

import kopo.aisw.hc.account.vo.AccountVO;

public interface AccountDAO {
	//계좌번호 생성기-자동 (수동은 추후 업데이트 예정)
	public double createAccNum(int productNum);
	//계좌 중복체크
	public boolean accDoubleCheck(double accNum);
	//계좌 개설하기
	public boolean openAnAccount(AccountVO account);
	//계좌 해지하기
	public boolean closeAnAccount(AccountVO account);
	
}

package kopo.aisw.hc.transaction.dao;

import kopo.aisw.hc.transaction.vo.TransactionVO;

public interface TransactionDAO {
	//이체
	public TransactionVO transfer(TransactionVO VTran) throws Exception;
	
	//입금
	public boolean deposit(TransactionVO dbTran);
	//출금
	public boolean withdraw(TransactionVO dbTran);
}

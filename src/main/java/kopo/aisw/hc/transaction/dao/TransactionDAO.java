package kopo.aisw.hc.transaction.dao;

import java.util.List;

import kopo.aisw.hc.transaction.vo.DBTransactionVO;
import kopo.aisw.hc.transaction.vo.ViewTransactionVO;

public interface TransactionDAO {
	//변환
	public List<DBTransactionVO> vTranToDbTran(ViewTransactionVO VTran);
	//이체
	public ViewTransactionVO transfer(ViewTransactionVO VTran) throws Exception;
	
	//입금
	public boolean deposit(DBTransactionVO dbTran);
	//출금
	public boolean withdraw(DBTransactionVO dbTran);
}

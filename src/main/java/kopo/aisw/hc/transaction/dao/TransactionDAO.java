package kopo.aisw.hc.transaction.dao;

import kopo.aisw.hc.transaction.vo.ViewTransactionVO;

public interface TransactionDAO {
	//출금이체 기록
	public boolean transaction(ViewTransactionVO transaction);
}

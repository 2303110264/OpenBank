package kopo.aisw.hc.transaction.dao;

import kopo.aisw.hc.transaction.vo.TransactionVO;

public interface TransactionDAO {
	//출금이체 기록
	public boolean transaction(TransactionVO transaction);
}

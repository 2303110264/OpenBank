package kopo.aisw.hc.transaction.service;

import kopo.aisw.hc.transaction.vo.ViewTransactionVO;

public interface TransactionService {
	
	//거래내역 추가
	public ViewTransactionVO transfer(ViewTransactionVO transaction) throws Exception;
	
}
	
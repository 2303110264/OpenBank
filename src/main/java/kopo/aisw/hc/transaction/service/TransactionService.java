package kopo.aisw.hc.transaction.service;

import kopo.aisw.hc.transaction.vo.TransactionVO;

public interface TransactionService {
	
	//거래내역 추가
	public TransactionVO transfer(TransactionVO transaction) throws Exception;
	
}
	
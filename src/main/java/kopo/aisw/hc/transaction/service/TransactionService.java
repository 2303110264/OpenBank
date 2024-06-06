package kopo.aisw.hc.transaction.service;

import java.util.List;

import kopo.aisw.hc.transaction.vo.DBTransactionVO;
import kopo.aisw.hc.transaction.vo.ViewTransactionVO;

public interface TransactionService {
	
	//거래내역 추가
	public List<DBTransactionVO> transfer(ViewTransactionVO transaction);
	
}

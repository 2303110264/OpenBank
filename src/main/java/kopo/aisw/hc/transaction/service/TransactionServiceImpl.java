package kopo.aisw.hc.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kopo.aisw.hc.transaction.dao.TransactionDAO;
import kopo.aisw.hc.transaction.vo.TransactionVO;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDAO tDao;
	
	@Override
	public TransactionVO transfer(TransactionVO transaction) throws Exception {
		return tDao.transfer(transaction);
	}

}

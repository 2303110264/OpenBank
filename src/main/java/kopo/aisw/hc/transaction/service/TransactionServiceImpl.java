package kopo.aisw.hc.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kopo.aisw.hc.transaction.dao.TransactionDAO;
import kopo.aisw.hc.transaction.vo.DBTransactionVO;
import kopo.aisw.hc.transaction.vo.ViewTransactionVO;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDAO tDao;
	
	@Override
	public List<DBTransactionVO> transfer(ViewTransactionVO transaction) {
		return tDao.transfer(transaction);
	}

}

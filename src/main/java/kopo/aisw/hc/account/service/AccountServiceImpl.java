package kopo.aisw.hc.account.service;

import org.springframework.stereotype.Service;

import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.transaction.vo.TransactionVO;

@Service
public class AccountServiceImpl implements AccountService {

	@Override
	public boolean openAnAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getOwnerName(double accNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getBalance(double accNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean transfer(TransactionVO transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeAnAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return false;
	}

}

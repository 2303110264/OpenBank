package kopo.aisw.hc.account.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.member.vo.MemberVO;
import kopo.aisw.hc.product.vo.ProductVO;
import kopo.aisw.hc.transaction.vo.TransactionVO;

@Transactional
@Repository
public class AccountDAOImpl implements AccountDAO {
	private Random rd = new Random();
	
	
	@Autowired
//	private SqlSessionTemplate sqlSession;
	private SqlSession sqlSession;
	
	//사전설정
	@Override
	public AccountVO preset(MemberVO member, int productNum) throws Exception {
		AccountVO openAcc = new AccountVO();
		//상품번호
		openAcc.setProductNum(productNum);
		//고객고유번호 (PK)
		openAcc.setCustomerId(member.getCustomerId());
		//고객이름
		openAcc.setCustomerName(member.getName());
		return openAcc;
	}
	
	//계좌 개설- 계좌번호 생성-자동
	@Override
	public AccountVO createAccNum(AccountVO account) {
		StringBuilder sb = new StringBuilder();
		long accNum;
		do {
			// 은행 고정번호 3+상품번호 3 = 6자리
			sb.append(245000+account.getProductNum()); 
			// random 6자리
			sb.append(rd.nextInt(900000)+100000);
			// 숫자 크기상 double 형태로 변환 (차라리 String이 나을지 나중에 고민)
			accNum = Long.parseLong(sb.toString());
		}while(sqlSession.selectOne("dao.AccountDAO.getOwnerName",(accNum))!=null);
		account.setAccNum(accNum);
		
		return account;
	}

	//계좌 개설-등록 (최근거래일 빼고 다 채워야함)
	@Override
	public boolean openAnAccount(AccountVO account, ProductVO product) {
		//베타 한정 잔액 추가
		account.setBalance(1000000);
		
		//등록일자 세팅
		LocalDate seoulNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
		//가입일자 세팅
		account.setRegDate(seoulNow.toString());
		//+N개월 = 만기일 세팅
		account.setRetDate(seoulNow.plusMonths(product.getDateOfDeposit()).toString());
		//이자율 세팅
		account.setInterestRate(product.getInterestRate());
		System.out.println(account);
		int a = sqlSession.insert("dao.AccountDAO.openAnAccount", account);
		return rollbackOrCommit(a==1);
	}

	//계좌목록 조회- customerId
	@Override
	public List<AccountVO> getAccList(int customerId) {
		List<AccountVO> list = sqlSession.selectList("dao.AccountDAO.selectAccByCustomer", customerId);
		return list;
	}

	//계좌 조회- 이름 체크
	@Override
	public String getOwnerName(long accNum) {
		AccountVO acc = sqlSession.selectOne("dao.AccountDAO.getOwnerName", accNum);
		return acc.getCustomerName();
	}
	//계좌 조회- 잔액 조회
	@Override
	public long getBalance(long accNum) {
		AccountVO acc = sqlSession.selectOne("dao.AccountDAO.getBalance", accNum);
		return acc.getBalance();
	}
	
	//입금
	@Override
	public boolean deposit(TransactionVO transaction) {
		int a = sqlSession.update("dao.AccountDAO.deposit", transaction);
		return rollbackOrCommit(a==1);
	}
	
	//출금
	@Override
	public boolean withdraw(TransactionVO transaction) {
		int a = sqlSession.update("dao.AccountDAO.withdraw", transaction);
		return rollbackOrCommit(a==1);
	}
	
	//계좌이체 (이게 입출금 외에 따로 필요한가??)
	@Override
	public boolean transfer(TransactionVO transaction) {
		int a = 0;
		a+= sqlSession.update("dao.AccountDAO.deposit", transaction);
		a+= sqlSession.update("dao.AccountDAO.withdraw", transaction);
		return rollbackOrCommit(a==2);
	}
	
	//계좌 해지
	@Override
	public boolean closeAnAccount(AccountVO account) {
		int a = sqlSession.delete("dao.AccountDAO.closeAnAccount", account);
		return rollbackOrCommit(a==1);
	}
	
	
	//트랜잭션 제어
	private boolean rollbackOrCommit(boolean b) {
		if(b) {
			sqlSession.commit();
			return true;
		}else {
			sqlSession.rollback();
			return false;
		}
	}

}

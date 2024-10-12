package kopo.aisw.hc.apicontroller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotNull;
import kopo.aisw.hc.account.service.AccountService;
import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;
import kopo.aisw.hc.transaction.service.TransactionService;
import kopo.aisw.hc.transaction.vo.TransactionVO;
/**
 * 임시 Controller
 * 추후 기능에 따라 AAccount, AMember 등으로 이동 예정
 * @author last_daquarter
 *
 */
@RestController
@RequestMapping("/dev/")
public class OpenBankController {
	
	@Autowired
	private AccountService as;
	
	@Autowired
	private MemberService ms;
	@Autowired
	private TransactionService ts;
	
	// 소유계좌목록
	@PostMapping("/account/list")
	public List<Map<String,Object>> accountList(@NotNull @RequestParam(name="include_cancel_yn") String yn,MemberVO m) {
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		map.put("responseDTime", LocalDateTime.now());
		map.put(yn, map);
		try {
			m = ms.getMemberIdByNameAndPhone(m);
			if(yn.toLowerCase().equals("y"))
				map.put("accountList", as.getAccountList(m));
			else if(yn.toLowerCase().equals("n"))
				map.put("accountList", as.getAccountListOnlyAvailable(m));
			else
				map.put("responseMessage", "include_cancel_yn 값을 확인해주세요.");
			list.add(map);
		}catch(Exception e) {
			
		}
		
		return list;
	}
	
	// 계좌 상세 // 이미 존재
	@PostMapping("detail")
	public ResponseEntity<?> accountDetail(HttpSession session, @RequestParam("accNum") String accNum) {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		AccountVO account = as.getAccount(accNum);
		if (userVO == null||userVO.getCustomerId() != account.getCustomerId()) {
			return new ResponseEntity<>("잘못된 접근입니다.", HttpStatus.UNAUTHORIZED);
		}
		List<TransactionVO> transaction = ts.getTransactionList(Long.parseLong(accNum));
		return new ResponseEntity<>(new Object[] { account, transaction }, HttpStatus.OK);
	}
	// 계좌 소유주 확인 (계좌 존재 확인) // 존재
	@GetMapping("accCheck")
	public String accCheck(@RequestParam("accNum") long accNum, HttpSession session) {
		if(session==null) return "잘못된 접근입니다.";
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		return as.getOwnerName(accNum);
	}
	
	// 계좌 잔액 확인 
	@PostMapping("account/bal")
	public List<Map<String, Object>> accountBalance(@NotNull @RequestParam(name="accNum") String accNum){
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		
		map.put("balance",as.getBalance(Long.parseLong(accNum)));
		
		return list;
	}
	
	// ---------------
	// 은행 인증 관련 기능들 (현재 보류)
	
}

package kopo.aisw.hc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import kopo.aisw.hc.account.service.AccountService;
import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.member.vo.MemberVO;
import kopo.aisw.hc.transaction.vo.TransactionVO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/transaction/")
public class TransactionController {
	
	@Autowired
	AccountService as;
	
//	@Autowired
//	TransactionService ts;
	
	
	//계좌이체
	@GetMapping("transfer")
	public String transfer(Model model, HttpSession session) {
		//(로그인 확인용 intercept 추가 완료 - 5/28 (applicationContext.xml참조))
		//세션정보 끌어오기
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		List<AccountVO> list = as.getAccountList(userVO);
		model.addAttribute("accList", list);
		
		TransactionVO t = new TransactionVO();
		model.addAttribute("t", t);
		return "transaction/transfer";
	}
	
	@RequestMapping(value="transfer", method = RequestMethod.POST )
	public String transfer(@ModelAttribute("t")TransactionVO t, 
			Model model, HttpSession session) {
		try {
			MemberVO userVO = (MemberVO) session.getAttribute("userVO");
			log.info(userVO.getCustomerId()+" - "+t);
			//입/출금 계좌 동일한지 확인
			//Long Acc = t.getWithdrawAcc();
			//if(Acc==t.getDepositAcc()) return "redirect:/transaction/transfer";
			
			//로그인중인 유저와 출금하려는 계좌 소유주가 같은지 확인
			AccountVO a = as.getAccount(t.getWithdrawAcc()+"");
			//아님
			if(a.getCustomerId()!=userVO.getCustomerId()) {
				log.fatal("송금 체크 요망 - 통장 번호, 소유자: "+a.getAccNum()+", "+a.getCustomerId()+"/ 요청자 ID:"+userVO.getCustomerId());
				return "redirect:/member/logout";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "transaction/transfer";
	}
}
package kopo.aisw.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kopo.aisw.hc.account.service.AccountService;
import kopo.aisw.hc.member.vo.MemberVO;
// git push origin localBranch:gitBranch 

@Controller
//@RequestMapping("/account/")
@RequestMapping("/")
public class AccountController {
	
	@Autowired
	private AccountService as;
	
	/*
	계좌 이체하기
	0. 상대 계좌 입력
	1. 상대 계좌 존재 확인하기 (없는 계좌: 일단 넘어감
						있는 계좌: 소유자 이름 출력)
	2. 이체금액 입력
	3. 차액 계산->출력
	--원래 결제비밀번호 입력해야하는데 어쩌지ㅋㅋ--
	4. 송금 => transactionVO -> 출금+입금 => 둘 다 성공해야 성공 -> 결과 출력
	 */

	//계좌생성
	@GetMapping("openAcc")
	public String openAnAcc(Model model, HttpSession session) {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		if(userVO==null) return "redirect:/member/signIn";
		
		
		return "account/open";
	}
	//계좌이체
	@GetMapping("transfer")
	public String transfer(Model model, HttpSession session) {
//		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
//		//로그인정보 없을 시 로그인 창으로 이동
//		if(userVO==null) return "redirect:/member/signIn";
		
		
		return "account/transfer";
	}
}

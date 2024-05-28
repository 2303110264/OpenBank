package kopo.aisw.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import kopo.aisw.hc.account.service.AccountService;
import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;
// git push origin localBranch:gitBranch 
import kopo.aisw.hc.product.service.ProductService;
import kopo.aisw.hc.product.vo.ProductVO;
import kopo.aisw.hc.transaction.vo.TransactionVO;

@Controller
//@RequestMapping("/account/")
@RequestMapping("/")
public class AccountController {
	
	@Autowired
	private AccountService as;
	@Autowired
	private MemberService ms;
	@Autowired
	private ProductService ps;
	
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
	@GetMapping("openAcc/{productNum}")
	public String openAnAcc(@PathVariable int productNum, Model model,
							HttpSession session) throws Exception {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		//고객정보 가져오기(패스워드 제외)
		userVO = ms.getProfile(userVO);
		AccountVO openAcc = as.preset(userVO, productNum);

		model.addAttribute("openAcc", openAcc);
		model.addAttribute("openAnAcc", false);
		return "account/open";
	}
	@PostMapping("openAcc")
	public String openAnAcc(@Valid @ModelAttribute("openAcc")AccountVO openAcc,
			BindingResult res, Model model) throws Exception {
		/**open 수정덜됨*/
		if(res.hasErrors()) return "account/open";
		
		//계좌번호 생성 및 등록
		as.openAnAccount(openAcc);
		
		/**result 페이지 비어있음*/
		return "account/result";
	}
	
	
	//계좌이체
	@GetMapping("transfer")
	public String transfer(Model model, HttpSession session) {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
//		//로그인정보 없을 시 로그인 창으로 이동
//		if(userVO==null) return "redirect:/member/signIn";
		//(intercept 추가 완료 - 5/28 (applicationContext.xml참조))
		
		TransactionVO t = new TransactionVO();
		
		
		
		return "account/transfer";
	}
}

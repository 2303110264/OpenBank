package kopo.aisw.hc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import kopo.aisw.hc.account.service.AccountService;
import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;
import kopo.aisw.hc.product.service.ProductService;
import kopo.aisw.hc.product.vo.ProductVO;
import kopo.aisw.hc.transaction.vo.TransactionVO;

// git push origin localBranch:gitBranch 
@Controller
@RequestMapping("/account/")
public class AccountController {
	
	@Autowired
	private AccountService as;
	@Autowired
	private MemberService ms;
	@Autowired
	private ProductService ps;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	//계좌생성
	@GetMapping("openAcc/{productNum}")
	public String openAnAcc(@PathVariable(value = "productNum") int productNum, Model model,
							HttpSession session) throws Exception {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		//고객정보 가져오기(패스워드 제외)
		userVO = ms.getProfile(userVO);
		ProductVO p = ps.selectProduct(productNum);
		//상품번호, 고객고유번호, 고객이름 세팅
		AccountVO openAcc = as.preset(userVO, productNum);
		
		model.addAttribute("product", p);
		model.addAttribute("openAcc", openAcc);
		return "account/open";
	}
	@PostMapping("openAcc/{productNum}")
	public String openAnAcc(@PathVariable(value = "productNum") int productNum,
			@ModelAttribute("openAcc")AccountVO openAcc,
			@RequestParam("password")String password, HttpSession session, Model model) {
//		if(res.hasErrors()) return "account/open";
		
		boolean b;
		//인증 또는 비밀번호 확인 로직이 빠져있음
		try {
			MemberVO m = (MemberVO) session.getAttribute("userVO");
			m.setPassword(password);
			//checkpwd 만드는게 좋을것
			if(ms.signIn(m)==null) return "account/open";
			//계좌번호 생성 및 등록
			b= as.openAnAccount(openAcc);
			model.addAttribute("openAnAcc", b);
			return "account/open";
		}catch(Exception e) {
			model.addAttribute("openAnAcc", false);
			e.printStackTrace();
			return "redirect:/product/view/"+productNum;
		}
		
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
	
	//계좌목록
	@GetMapping("list")
	public String accountList(Model model, HttpSession session) {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		List<AccountVO> list = as.getAccountList(userVO);
		model.addAttribute("accList", list);
		return "account/list";
	}
	@PostMapping("list")
	public String accountList(Model model, @RequestParam("accNum")String accNum) {
		model.addAttribute("account", accNum);
		return "account/detail";
	}
}

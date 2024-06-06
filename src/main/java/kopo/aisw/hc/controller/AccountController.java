package kopo.aisw.hc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import kopo.aisw.hc.account.service.AccountService;
import kopo.aisw.hc.account.vo.AccountVO;
import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;
import kopo.aisw.hc.product.service.ProductService;
import kopo.aisw.hc.product.vo.ProductVO;
import kopo.aisw.hc.transaction.vo.ViewTransactionVO;
import lombok.extern.log4j.Log4j2;

// git push origin localBranch:gitBranch 
@Log4j2
@Controller
@RequestMapping("/account/")
public class AccountController {
	
	@Autowired
	private AccountService as;
	@Autowired
	private MemberService ms;
	@Autowired
	private ProductService ps;

	
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
		
		boolean b;
		//인증 또는 비밀번호 확인 로직이 빠져있음
		try {
			MemberVO m = (MemberVO) session.getAttribute("userVO");
			m.setPassword(password);
			//임시
			if(ms.checkPwd(m)) return "account/open";
			//계좌번호 생성 및 등록
			b= as.openAnAccount(openAcc);
			if(!b) {
				model.addAttribute("openAnAcc", b);
				log.error(b+"-"+m.getUserId()+" open account : "+openAcc.toString());
				return "redirect:/product/view"+productNum;
			}else {
				model.addAttribute("openAnAcc", b);
				log.info(b+"-"+m.getUserId()+" open account : "+openAcc.toString());
				return "redirect:/account/";
			}
		}catch(Exception e) {
			model.addAttribute("openAnAcc", false);
			e.printStackTrace();
			return "redirect:/product/view/"+productNum;
		}
		
	}
	
	
	
	//계좌목록
	@GetMapping("")
	public String accountList(Model model, HttpSession session) {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		List<AccountVO> list = as.getAccountList(userVO);
		model.addAttribute("accList", list);
		return "account/list";
	}
	@PostMapping("")
	public String accountList(Model model, @RequestParam("accNum")String accNum) {
		AccountVO account = as.getAccount(accNum);
		model.addAttribute("account", account);
		System.out.println(account);
		return "account/detail";
	}
}

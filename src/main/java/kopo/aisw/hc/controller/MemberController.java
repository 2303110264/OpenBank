package kopo.aisw.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import kopo.aisw.hc.api.Api;
import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;

@Validated
@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService ms;
	@Autowired
    private Api api;
    
	@GetMapping("signIn")
	public String signIn(Model model) {
		MemberVO m = new MemberVO();
		model.addAttribute("m", m);
		
		return "user/signIn";
	}
	
	@GetMapping("signUp")
	public String signUp(Model model) {
		MemberVO m = new MemberVO();
		model.addAttribute("m", m);
		
		return "user/signUp";
	}
	
	@PostMapping("signUp")
	public String signUp(@Valid @ModelAttribute("m")MemberVO m, BindingResult res, Model model) throws Exception {
		//if(res.hasErrors()) return "user/signUp";
		
		//id 중복체크
		if(ms.idDuplicationCheck(m.getUserId())) model.addAttribute("idDuplicationCheck", true);
		// 주민번호+이름, 전화번호, 이메일 체크 남음
		// humanDC, phoneDC, mailDC
		if(ms.humanDuplicationCheck(m)) model.addAttribute("humanDuplicationCheck", true);
		if(ms.phoneDuplicationCheck(m.getPhoneNum())) model.addAttribute("phoneDuplicationCheck", true);
		if(ms.mailDuplicationCheck(m.getEmail())) model.addAttribute("mailDuplicationCheck", true);
		
		// 가입 가능?
		if(!ms.signUp(m)) model.addAttribute("signUp", false);
		else model.addAttribute("signUp", true);
		return "user/signUp";
	}
	
	@RequestMapping("jusoPopup")
	public String jusoPopup(Model model) {
		model.addAttribute("juso", api.getJuso());
		return "user/jusoPopup";
	}
}

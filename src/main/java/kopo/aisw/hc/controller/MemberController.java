package kopo.aisw.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;

@Validated
@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@GetMapping("user/signUp")
	public void signUp(Model model) {
		MemberVO m = new MemberVO();
		model.addAttribute("m", m);
	}
	
//	@RequestMapping("/login")
//	public String Login() {
//		return "user/login";
//	}
	
	@PostMapping("user/signUp")
	public String signUp(@Valid @ModelAttribute("m")MemberVO m, BindingResult res) throws Exception {
		if(res.hasErrors()) return "user/signUp";
		ms.signUp(m);
		return "redirect:/bank/";
	}
	
}

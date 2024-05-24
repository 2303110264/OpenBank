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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import kopo.aisw.hc.api.Api;
import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;

@Controller
@SessionAttributes({"userVO"})
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService ms;
	@Autowired
    private Api api;
    
	@GetMapping("profile")
	public String profile(Model model, HttpSession session) {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		model.addAttribute("m", userVO);
		String msg = (String) session.getAttribute("message");
		model.addAttribute("message", msg);
		return "user/signIn";
	}
	
	@PostMapping("profile")
	public String profile(@Valid @ModelAttribute("userVO")MemberVO userVO,
			BindingResult res, HttpSession session){
		if(userVO.getPassword().length()<1) {
			ms.edit(userVO);
			session.setAttribute("message", "수정에 성공했습니다");
		}else {
			if(res.hasErrors()){
				session.setAttribute("message", "수정에 실패했습니다. 다시 시도해주세요.");
			}else{
				ms.edit(userVO);
				session.setAttribute("message", "수정에 성공했습니다");
			}
		}
		return "user/profile";
	}
	
	@GetMapping("signIn")
	public String signIn(Model model) {
		MemberVO m = new MemberVO();
		model.addAttribute("m", m);
		
		return "user/signIn";
	}
	
	@PostMapping("signIn")
	public String signIn(@ModelAttribute("m")MemberVO m, BindingResult res, 
			Model model) throws Exception {
		MemberVO userVO = ms.signIn(m);
		if(userVO==null) {
			model.addAttribute("loginChk", false);
			return "user/signIn";
		}else {
			model.addAttribute("userVO", userVO);
			return "redirect:/bank/";
		}
	}
	
	@GetMapping("logout")
	public String logout(SessionStatus state) {
		state.setComplete();
		return "redirect:/bank/";
	}
	
	@GetMapping("signUp")
	public String signUp(Model model) {
		MemberVO m = new MemberVO();
		model.addAttribute("m", m);
		model.addAttribute("signUp", false);
		return "user/signUp";
	}
	
	@PostMapping("signUp")
	public String signUp(@Valid @ModelAttribute("m")MemberVO m, BindingResult res, Model model) throws Exception {
		//if(res.hasErrors()) return "user/signUp";
		
		//id 중복체크
		if(ms.idDuplicationCheck(m.getUserId())) model.addAttribute("idDuplicationCheck", true);
		// 주민번호+이름->아이디체크, 전화번호, 이메일 체크 남음
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

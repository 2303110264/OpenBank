package kopo.aisw.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    
	//프로필 수정
	@GetMapping("profile")
	public String profile(Model model, HttpSession session) {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		if(userVO==null) return "redirect:/member/signIn";
		userVO = ms.getProfile(userVO);
		model.addAttribute("m", userVO);
		return "user/profile";
	}
	@PostMapping("profile")
	public String profile(@Valid @ModelAttribute("m")MemberVO userVO,
			BindingResult res, Model model){
		if(userVO.getPassword().length()<1) {
			ms.edit(userVO);
			model.addAttribute("message", "수정에 성공했습니다");
		}else {
			if(res.hasErrors()){
				model.addAttribute("message", "수정에 실패했습니다. 다시 시도해주세요.");
			}else{
				ms.edit(userVO);
				model.addAttribute("message", "수정에 성공했습니다");
			}
		}
		return "user/profile";
	}

	//로그인
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
	
	//로그아웃
	@GetMapping("logout")
	public String logout(SessionStatus state) {
		state.setComplete();
		return "redirect:/bank/";
	}
	
	//회원가입
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
		if(ms.idDoubleCheck(m.getUserId())) model.addAttribute("idDoubleCheck", true);
		//이미 등록된 유저인지 확인
		boolean customer = ms.humanDoubleCheck(m);
		if(customer) model.addAttribute("humanDoubleCheck", true);
		//전화번호 중복체크
		if(ms.phoneDoubleCheck(m.getPhoneNum())) model.addAttribute("phoneDoubleCheck", true);
		//이메일 중복체크
		if(ms.mailDoubleCheck(m.getEmail())) model.addAttribute("mailDoubleCheck", true);
		// 가입 가능?
		if(customer) customer = ms.updateBankId(m);
		else customer = ms.signUp(m);
		if(!ms.signUp(m)) model.addAttribute("signUp", false);
		else model.addAttribute("signUp", true);
		return "user/signUp";
	}
	
	//우편번호&주소 기입 api
	@RequestMapping("jusoPopup")
	public String jusoPopup(Model model) {
		model.addAttribute("juso", api.getJuso());
		return "user/jusoPopup";
	}
}

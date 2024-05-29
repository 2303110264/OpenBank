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
		userVO = ms.getProfile(userVO);
		model.addAttribute("m", userVO);
		return "user/profile";
	}
	@PostMapping("profile")
	public String profile(@Valid @ModelAttribute("m")MemberVO profileVO,
			BindingResult res, HttpSession session, Model model){
		System.out.println(profileVO);
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		System.out.println(userVO);
		//세션과 아이디가 다르면 제거
		if(!(userVO.getCustomerId()==profileVO.getCustomerId()))
			return "redirect:/bank/";
		//폼에서 display none이나 함수도 괜찮을 거긴 한데...일단은 세션에서 가져오는 것으로
		if(profileVO.getPassword().length()<8)
			profileVO.setPassword(null);
		
		boolean result = ms.edit(profileVO);
		model.addAttribute("message", result);
		return "user/profile";
	}
	
	//로그인
	@GetMapping("signIn")
	public String signIn(Model model, HttpSession session) {
		//이미 로그인상태일 경우 메인화면으로
		if(session.getAttribute("userVO")!=null) return "redirect:/bank/";
		MemberVO m = new MemberVO();
		model.addAttribute("m", m);
		return "user/signIn";
	}
	
	@PostMapping("signIn")
	public String signIn(@ModelAttribute("m")MemberVO m, BindingResult res, 
			Model model, HttpSession session) throws Exception {
		MemberVO userVO = ms.signIn(m);
		if(userVO==null) {
			model.addAttribute("loginChk", false);
			return "user/signIn";
		}else {
			model.addAttribute("userVO", userVO);

			//로그인이 필요한 모든 링크에 interceptor를 걸었으나 수동임... url정리 필요.
			// 	(applicationContext.xml참조)
			//kopo.aisw.hc.interceptor.SignInInterceptor에 세션에 preUrl을 추가하는 코드가 있음
			String preUrl = (String) session.getAttribute("preUrl");
			if(preUrl!=null) return "redirect:"+preUrl.substring(3);
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

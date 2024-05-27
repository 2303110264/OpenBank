package kopo.aisw.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kopo.aisw.hc.api.Api;
import kopo.aisw.hc.member.vo.MemberVO;

@Controller
@RequestMapping("/")
public class TransactionControl {
	
//	@Autowired
//	private TransactionService ts;
	@Autowired
	private Api api;
	
	//계좌이체
	@GetMapping("transfer")
	public String transfer(Model model, HttpSession session) {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		if(userVO==null) return "redirect:/member/signIn";
		
		
		return "transaction/transfer";
	}
}

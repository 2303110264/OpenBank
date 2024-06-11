package kopo.aisw.hc.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import kopo.aisw.hc.account.service.AccountService;
import kopo.aisw.hc.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/account/")
public class AAccountController {
	@Autowired
	AccountService as;
	
	@GetMapping("accCheck")
	public String accCheck(@RequestParam("accNum") long accNum, HttpSession session) {
		if(session==null) return "잘못된 접근입니다.";
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		log.info(userVO.getCustomerId()+" => "+accNum);
		return as.getOwnerName(accNum);
	}
}

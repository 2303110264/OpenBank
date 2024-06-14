package kopo.aisw.hc.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import kopo.aisw.hc.account.service.AccountService;
import kopo.aisw.hc.account.vo.AccountVO;
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
	
	@GetMapping("info") //지금은 세션으로 체크하지만 ㅠㅠ 나중에는 헤더값 받아오고싶음
	public AccountVO accInfo(HttpSession session, @RequestParam("accNum") String accNum) {
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		AccountVO acc = as.getAccount(accNum);
		if(acc.getCustomerId()!=userVO.getCustomerId()) return null;
		return acc;
	}
	
}
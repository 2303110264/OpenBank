package kopo.aisw.hc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j	
@RestController
public class TestController {
	/* 물론 안됐음
	public static void main(String args[]) {
		log.info("내가 살다살다 컨트롤러에 메인메소드도 뽑아보고...");
	}
	*/
	@Autowired
	MemberService ms;
	
	@GetMapping("/api-test/1")
	public MemberVO testFilter() {
		MemberVO m = new MemberVO();
		m.setCustomerId(1);
		m = ms.getProfile(m);
		log.info("API 테스트중..."+m);
		return m;
	}
	
	@GetMapping("/test")
	public String testIndex(Locale locale, Model model) {
		
		System.out.println("콘솔에 출력이 왜 안 될까...");
		log.info("Slf4j2 Testing...");
		log.debug("Slf4j2 Debuging...");
		System.out.println("된다!!!!!!!!!");
		return "String 반환 테스트 - with RestController";
	}
	
	public void test() {
		log.info("info - saveTest");
		log.debug("debug -saveTest");
	}
}

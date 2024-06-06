package kopo.aisw.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class TestController {
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
	
}

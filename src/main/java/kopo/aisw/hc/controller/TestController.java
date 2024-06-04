package kopo.aisw.hc.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j	
@Controller
public class TestController {
	/* 물론 안됐음
	public static void main(String args[]) {
		log.info("내가 살다살다 컨트롤러에 메인메소드도 뽑아보고...");
	}
	*/

	@GetMapping("/test")
	public String testIndex(Locale locale, Model model) {
		Log l = new Log();
		l.logtest();
		
		System.out.println("콘솔에 출력이 왜 안 될까...");
		log.info("Slf4j2 Testing...");
		log.debug("Slf4j2 Debuging...");
		System.out.println("된다!!!!!!!!!");
		log.error("근데 콘솔에만됨ㅋ 파일저장이 안됨. 이문제로 주말을 다 날렸다. 이거 지능 문제야...");
		log.error("Java application으로 run할때만 기록됨.");
		return "main";
	}
	public void test() {
		log.info("info - saveTest");
		log.debug("debug -saveTest");
	}
}

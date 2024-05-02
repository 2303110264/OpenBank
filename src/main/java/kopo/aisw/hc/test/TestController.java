package kopo.aisw.hc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/test")
	public String testIndex() {
		return "main";
	}
//	@RequestMapping("/ob")
//	public String testMain() {
//		return "main";
//	}
	
}

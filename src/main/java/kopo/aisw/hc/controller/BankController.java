package kopo.aisw.hc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class BankController {
	@RequestMapping("bank/")
	public String bankMain() {
		return "bankMain";
	}
	
	@RequestMapping("home/")
	public String home(HttpServletRequest request) throws Exception{
		return "home";
	}
	
}

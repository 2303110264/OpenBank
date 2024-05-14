package kopo.aisw.hc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankController {
	@RequestMapping("/bank/")
	public String bankMain() {
		return "bankMain";
	}
	
}

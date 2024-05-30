package kopo.aisw.hc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BankController {
	@RequestMapping("bank/")
	public String bankMain() {
		return "bankMain";
	}
	
	@RequestMapping("about")
	public String about(){
		return "example/about";
	}
	@RequestMapping("work")
	public String work(){
		return "example/work";
	}
	@RequestMapping("work-single")
	public String workSingle(){
		return "example/work-single";
	}
	@RequestMapping("pricing")
	public String pricing(){
		return "example/pricing";
	}
	@RequestMapping("contact")
	public String contact(){
		return "example/contact";
	}
	
}

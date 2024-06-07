package kopo.aisw.hc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/")
public class BankController {
	@RequestMapping("")
	public String bankMain() {
		log.info("Bank Start (L)");
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

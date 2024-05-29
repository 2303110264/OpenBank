package kopo.aisw.hc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class BankController {
	@Autowired
	private PasswordEncoder passwordEncoder; // PasswordEncoder 추가
	@RequestMapping("bank/")
	public String bankMain() {
		//System.out.println(passwordEncoder.encode("admin"));
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

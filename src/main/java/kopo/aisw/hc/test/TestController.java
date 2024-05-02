package kopo.aisw.hc.test;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Controller
@Getter
@ToString
@Log4j2
public class TestController {
	
	@RequestMapping(value="/test", method =RequestMethod.GET)
	public String testIndex(Locale locale, Model model) {
		//log.info("Log4j2 Testing...");
		return "main";
	}
//	@RequestMapping("/ob")
//	public String testMain() {
//		return "main";
//	}
	
}

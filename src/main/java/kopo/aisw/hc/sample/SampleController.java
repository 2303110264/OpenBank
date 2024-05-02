package kopo.aisw.hc.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
	@RequestMapping("/")
	public String sampleMain() {
		return "sampleMain";
	}
}

package kopo.aisw.hc.member.kakao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import kopo.aisw.hc.api.Api;
import kopo.aisw.hc.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SessionAttributes({"userVO"})
@RequiredArgsConstructor
@RequestMapping("/member")
public class KakaoController {
	@Autowired
	private Api api;
	private KakaoService ks = new KakaoService();
	
    @GetMapping("/kakao-login")
    public String callback(Model m, @RequestParam("code") String code) {
    	String accessToken = ks.getAccessTokenFromKakao(code, api.getKakaoRest());
        MemberVO member = new MemberVO();
        member.setUserId(accessToken);
    	m.addAttribute("userVO", member);
    	return "redirect:/";
    }
}
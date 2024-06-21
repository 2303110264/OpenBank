package kopo.aisw.hc.member.kakao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kopo.aisw.hc.api.Api;
import kopo.aisw.hc.member.service.MemberService;
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
	@Autowired
	private MemberService ms;
	
    @GetMapping("/kakao-login")
    public void callback(Model m, @RequestParam("code") String code,
    					HttpSession session, HttpServletResponse response) throws Exception {
    	KakaoVO accessToken = ks.getAccessTokenFromKakao(code, api.getKakaoRest());
        
    	//시간 부족으로 구현한척 (원래는 kakao에서 프로필값을 받아와야함)
    	//DB에 수동으로 id 202에 관한 정보 추가 필요
    	MemberVO member = new MemberVO();
        member.setUserId(accessToken.getAccessToken());
        member.setCustomerId(202);
        member.setCustomerType(0);
        member.setName(ms.getProfile(member).getName());
        
    	m.addAttribute("userVO", member);
    	String preUrl = (String) session.getAttribute("preUrl");
    	System.out.println(ks.getKakaoUserCode(accessToken));
		if(preUrl!=null)
			response.sendRedirect(preUrl);
		else
			response.sendRedirect("/ob/");
    }
}
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
	
	@Autowired
	private KakaoService ks;

	@Autowired
	private MemberService ms;
	
    @GetMapping("/kakao-login")
    public void callback(Model m, @RequestParam("code") String code,
    					HttpSession session, HttpServletResponse response) throws Exception {
    	MemberVO member = new MemberVO();
    	KakaoVO accessToken = ks.getAccessTokenFromKakao(code, api.getKakaoRest());
    	accessToken = ks.getKakaoUserCode(accessToken);
    	
    	member.setPassword(accessToken.getId()+"");
    	member.setPassword(ms.Hashing(member.getPassword()));
    	// id값만 고정값인거같음(유저별)
    	// id값을 userId(DB상 BankId), id token값을 pw로 (ㅠㅠ원래이러면안됨)
    	accessToken.setAccessToken(member.getPassword());
    	member = ks.kakaoToMember(accessToken);
    	
    	// 기존 회원 체크 - 이름/주민번호/전화번호
    	// 회원이 아니면 가입절차 후 로그인
    	if(ms.humanDoubleCheck(member).getName()==null) {
    		ms.signUp(member);
    	}else if(ms.humanDoubleCheck(member).getUserId()==null){
    		ms.updateBankId(member);
		}
    	
    	member = ms.signIn(member);
    	
		if(member==null) {
			m.addAttribute("loginChk", false);
		}else {
			m.addAttribute("userVO", member);
		}
    	String preUrl = (String) session.getAttribute("preUrl");
		if(preUrl!=null)
			response.sendRedirect(preUrl);
		else
			response.sendRedirect("/ob/");
    }
//    @GetMapping("/test")
//    public String testing() {
//    	// autowired테스트
//    	System.out.println(ks!=null);
//    	return "oldIndex";
//    }
}
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
    	MemberVO member = new MemberVO();
    	member.setUserId(accessToken.getId()+"");
    	accessToken = ks.getKakaoUserCode(accessToken);

    	//시간 부족으로 구현한척 (원래는 kakao에서 프로필값을 받아와야함)
    	//DB에 수동으로 id 202에 관한 정보 추가 필요
    	// 고정값인지 체크
    	// id token = eyJraWQiOiI5ZjI1MmRhZGQ1ZjIzM2Y5M2QyZmE1MjhkMTJmZWEiLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiJlZjgwNjkyYTEzNGFlYWIxODcxMTFmNWI3ZGZmMDU0OSIsInN1YiI6IjM1MTkzMTU3MTQiLCJhdXRoX3RpbWUiOjE3MTkwNDA5NzcsImlzcyI6Imh0dHBzOi8va2F1dGgua2FrYW8uY29tIiwiZXhwIjoxNzE5MDYyNTc3LCJpYXQiOjE3MTkwNDA5NzcsImVtYWlsIjoicnVoeWVvbl9qQGRhdW0ubmV0In0.aEeJwP_YKRFx9bzO4GlYT_ppU3Q5Zol93BIr3A2k4GIGtpOwDX-E6d8Ph9zFIHNVFIArzcjjfhHCnRy3yNweqS4ThHkwZIO8rpDa2IRVqsiHMN9YAQsF0mSlo9OexwhtXtQ-7dCdk67DRgIC-uLK_wixOJYt00REKkJpbfs3pU9GrhpFLXS_Zytgd4BwMjjxQUjcRKH8L18vg_Jj6N1Ze89871fvv2QccMiCwhWimHsXESHsAznV12_jATcm9uUgkl-0OoLhyLqoRhPRxU4I461DzacVgXtPlT67CbrsrYNt_X2BNUQmvbqMCTACSoD-_hg1TZ91pqsmDhl-wSZ2ew
    	// profile id = 3519315714
    	member.setName(accessToken.getKakaoAccount().getName());
        member.setCustomerId(accessToken.getId());
        member.setCustomerType(0);
        
    	m.addAttribute("userVO", member);
    	String preUrl = (String) session.getAttribute("preUrl");
		if(preUrl!=null)
			response.sendRedirect(preUrl);
		else
			response.sendRedirect("/ob/");
    }
}
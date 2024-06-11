package kopo.aisw.hc.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;


@RestController
@RequestMapping("/member/")
public class AMemberController {
	@Autowired
	MemberService ms;
	
	
	@DeleteMapping(value = "quit", produces = "application/text; charset=utf8")
	public String quit(@RequestBody MemberVO m, HttpSession session){
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		if(userVO.getCustomerType()==1) return "관리자는 해당 경로로 탈퇴할 수 없습니다.";
		if(m.getCustomerId()!=userVO.getCustomerId()) return "잘못된 접근입니다.";
		boolean bool = ms.checkPwd(m);
		if(bool) {
			int a = ms.quitMember(m);
			if(a>0) {
				return "탈퇴 처리가 완료되었습니다.";
			}
		}else {
			return "비밀번호가 맞지 않습니다.";
		}
		return "탈퇴 실패. 다시 시도해주세요.";
	}
}

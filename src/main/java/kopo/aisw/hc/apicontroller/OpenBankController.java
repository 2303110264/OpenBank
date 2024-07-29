package kopo.aisw.hc.apicontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import kopo.aisw.hc.account.service.AccountService;
import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;
/**
 * 임시 Controller
 * 추후 기능에 따라 AAccount, AMember 등으로 이동 예정
 * @author last_daquarter
 *
 */
@RestController
@RequestMapping("/o")
public class OpenBankController {
	
	@Autowired
	private AccountService as;
	
	@Autowired
	private MemberService ms;
	
	@PostMapping("/account/list")
	public List<Map<String,Object>> accountList(@NotNull @RequestParam(name="include_cancel_yn") String yn,MemberVO m) {
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		
		m = ms.getMemberIdByNameAndPhone(m);
		if(yn.toLowerCase().equals("y"))
			map.put("accountList", as.getAccountList(m));
		else if(yn.toLowerCase().equals("n"))
			map.put("accountList", as.getAccountListOnlyAvailable(m));
		else
			map.put("responseMessage", "include_cancel_yn 값을 확인해주세요.");
		list.add(map);
		
		return list;
	}
	
	// 계좌 상세는 이미 존재
}

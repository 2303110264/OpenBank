package kopo.aisw.hc.openbank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kopo.aisw.hc.account.service.AccountService;
import kopo.aisw.hc.member.service.MemberService;
import kopo.aisw.hc.member.vo.MemberVO;

@RestController
@RequestMapping("/o")
public class OpenBankController {
	
	@Autowired
	private AccountService as;
	
	@Autowired
	private MemberService ms;
	
	@PostMapping("/account/list")
	public List<Map<String,Object>> accountList(@RequestParam(name="include_cancel_yn") String yn,MemberVO m) {
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		
		
		
		m = ms.getMemberIdByNameAndPhone(m);
		if(yn.toLowerCase().equals("y"))
			map.put("accountList", as.getAccountList(m));
		else if(yn.toLowerCase().equals("n"))
			map.put("accountList", as.getAccountList(m));
		else
			map.put("responseMessage", "''");
		list.add(map);
		
		return list;
	}
}

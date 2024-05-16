package kopo.aisw.hc.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kopo.aisw.hc.member.vo.MemberVO;

@RestController
@RequestMapping("/ajax")
public class ResTestController {
	/**
		@ResponseBody
		@RequestMapping("/resBody.json")
		public Map<String, String> resJsonBody() {
			Map<String, String> result = new HashMap<String, String>();
			result.put("id", "hong");
			result.put("name", "이름");
			return result;
		}

		@RequestMapping("/resVOBody.json")
		@ResponseBody
		public MemberVO resJsonVOBody() {
			MemberVO vo = new MemberVO();
			vo.setId("hong");
			vo.setName("홍길동");
			vo.setPassword("1234");
			return vo;
		}

		@RequestMapping("/resStringListBody.json")
		@ResponseBody
		public List<String> resJsonStringListBody() {
			List<String> list = new ArrayList<>();
			for (int i = 1; i < 4; i++) {
				list.add(String.valueOf(i));
			}
			return list;
		}
	*/
		@RequestMapping("/resVOListBody.json")
		@ResponseBody
		public List<MemberVO> resJsonVOListBody() {
			List<MemberVO> list = new ArrayList<>();
			for (int i = 1; i < 4; i++) {
				MemberVO vo = new MemberVO();
				vo.setUserId("userId");
				vo.setName("홍길동");
				vo.setPassword("1234");
				list.add(vo);
			}
			return list;
		}


}

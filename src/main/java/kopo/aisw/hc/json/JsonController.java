package kopo.aisw.hc.json;

import java.io.IOException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import kopo.aisw.hc.ajax.ResponseVO;
import kopo.aisw.hc.member.vo.MemberVO;

@RestController
public class JsonController {
	
	@RequestMapping("/api")
	public ResponseVO test() {
		ResponseVO res = new ResponseVO();
		MemberVO m = new MemberVO();
		m.setUserId("id");
		m.setPassword("1234");
		m.setName("name");
		res.setMember(m);
		res.setResponseCode(200);
		return res;
	}
	
	@GetMapping("/api/{id}")
	public ResponseVO getTest(@RequestHeader("Authorization") String Authorization,
								@PathVariable(value = "id") String id) {
		ResponseVO res = new ResponseVO();
		try{
			MemberVO m = new MemberVO();
			m.setUserId(id);
			res.setMember(m);
			return res;
		}catch(Exception e){
			res.setResponseCode(400);
			return res;
		}
	}
	@ExceptionHandler(value = NullPointerException.class)
    public String nullPointerException(NullPointerException ex){
        return "nullPointerException execute";
    }
	
	//Auth Header test
	@PostMapping("/api/{id}")
	public ResponseVO getTest2(@RequestHeader("Authorization") String Authorization,
								@PathVariable(value = "id") String id) {
		ResponseVO res = new ResponseVO();
		MemberVO m = new MemberVO();
		m.setUserId(id);
		res.setMember(m);
		return res;
	}
	
/*	//JSON을 정렬해서 출력하고 싶었음...
	@GetMapping("/api2")
	public String test2() throws Exception {
		ResponseVO res = new ResponseVO();
		MemberVO m = new MemberVO();
		m.setUserId("id");
		m.setPassword("1234");
		m.setName("name");
		res.setMember(m);
		res.setResponseCode(200);
		ObjectMapper om = new ObjectMapper();
		om.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
		String json = om.writeValueAsString(res);
		return json;
	}
*/
}

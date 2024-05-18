package kopo.aisw.hc.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

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
	public ResponseVO getTest(@PathVariable(value = "id") String id) {
		ResponseVO res = new ResponseVO();
		try{
			MemberVO m = new MemberVO();
			m.setUserId(id);
			res.setMember(m);
			System.out.println(requestTest());
			return res;
		}catch(Exception e){
			res.setResponseCode(400);
			return res;
		}
	}
	
	//Auth Header test
	@PostMapping("/api/{id}")
	public ResponseVO getTest2(@RequestHeader("Authorization") String Authorization,
								@PathVariable(value = "id") String id) {
		ResponseVO res = new ResponseVO();
		MemberVO m = new MemberVO();
		m.setUserId(id);
		m.setName(Authorization);
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
	
	public String requestTest() {
		StringBuilder url = new StringBuilder("http://localhost:8008/ob/api/headerTesting");
		String testKey = "testing-testing"; // kakao REST api Key(it's work!) or admin key(i don't know)
		
		try{
//			url.append("?" + URLEncoder.encode("x","UTF-8") + "=" + URLEncoder.encode(y, "UTF-8")); 
//			url.append("&" + URLEncoder.encode("y","UTF-8") + "=" + URLEncoder.encode(x, "UTF-8")); 
			
			URL url2 = new URL(url.toString());
			
			HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
			conn.setRequestMethod("POST");
//			conn.setRequestProperty("X-Requested-With", "curl");
			conn.setRequestProperty("Authorization", "TestAK " + testKey);
			
//			conn.setRequestProperty("content-type", "application/json");
//			conn.setDoOutput(true);
			
			Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			
			StringBuffer response = new StringBuffer();
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine); 
			} 
			System.out.println("responseCode : "+conn.getResponseCode());
			System.out.println(response.toString());
			return response.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	public String XYToAddress(String x, String y) {
		StringBuilder kakaoUrl = new StringBuilder("https://dapi.kakao.com/v2/local/geo/coord2address.json");
		String kakaoKey = "f6c6a378ac29dd69ca7c5f830601e097"; // kakao REST api Key(it's work!) or admin key(i don't know)
		
		try{
            kakaoUrl.append("?" + URLEncoder.encode("x","UTF-8") + "=" + URLEncoder.encode(y, "UTF-8")); 
            kakaoUrl.append("&" + URLEncoder.encode("y","UTF-8") + "=" + URLEncoder.encode(x, "UTF-8")); 
			
            URL url = new URL(kakaoUrl.toString());
            
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            //conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Requested-With", "curl");
            conn.setRequestProperty("Authorization", "KakaoAK " + kakaoKey);
            //conn.setRequestProperty("content-type", "application/json");
            //conn.setDoOutput(true);
            
            Charset charset = Charset.forName("UTF-8");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
            
            StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
            	response.append(inputLine); 
            } 
            System.out.println("responseCode : "+conn.getResponseCode());
            System.out.println(response.toString());
            return response.toString();
            
		} catch (Exception e) {
    		e.printStackTrace();
			return "XYToAddress error";
		}
		
	}
	
	// Header넣는데 참고하려고 긁어와봄
	// coord2address json parsing (주소로 변환)
	public String JSONToAddress
	(HttpServletResponse response) {
	//(String response) {
		try { 
			// JSON 객체로 변환하기 -> response([{ ...json array... }])
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(response);
			JSONPObject jsonObject = new JSONPObject("response", response);
			// JSON to JAVA Object 
			//VO vo = om.readValue("jsonString", VO.class);
			
			/*
			JSONObject jsonObject = new JSONObject(response);

	        // "documents" 키의 값 가져오기 (JSONArray)
	        JSONArray documentsArray = jsonObject.getJSONArray("documents");
	        
	        // "documents" 배열에서 첫 번째 요소 가져오기
	        JSONObject firstDocument = documentsArray.getJSONObject(0);
	        
	        // "address" 객체 가져오기
	        JSONObject addressObject = firstDocument.getJSONObject("address");
	        
	        // 원래 index 방식으로 불러오는 게 낫다고 함
	        String region1DepthName = addressObject.getString("region_1depth_name");
	        String region2DepthName = addressObject.getString("region_2depth_name");
	        String region3DepthName = addressObject.getString("region_3depth_name");
	        
	        return region1DepthName+" "+region2DepthName+" "+region3DepthName;
			 */
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
}
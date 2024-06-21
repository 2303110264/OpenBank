package kopo.aisw.hc.member.kakao;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaoService {
	
    private final String KAUTH_TOKEN_URL_HOST="https://kauth.kakao.com";
    private final String KAUTH_USER_URL_HOST= "https://kapi.kakao.com";

    public KakaoVO getAccessTokenFromKakao(String code, String clientId) {
        log.info(code+"\t"+clientId);
    	RestTemplate restTemplate = new RestTemplate();
        String url = KAUTH_TOKEN_URL_HOST + "/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        String requestBody = String.format(
            "grant_type=authorization_code&client_id=%s&code=%s", 
            clientId, 
            code
        );
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<KakaoVO> response = restTemplate.exchange(
            url, 
            HttpMethod.POST, 
            request, 
            KakaoVO.class
        );

        KakaoVO kakaoRes = response.getBody();
        System.out.println(kakaoRes);

        log.info(" [Kakao Service] Access Token ------> {}", kakaoRes.getAccessToken());
        log.info(" [Kakao Service] Refresh Token ------> {}", kakaoRes.getRefreshToken());
        log.info(" [Kakao Service] Id Token ------> {}", kakaoRes.getIdToken());
        log.info(" [Kakao Service] Scope ------> {}", kakaoRes.getScope());

        return kakaoRes;
    }
    
    public KakaoVO getKakaoUserCode(KakaoVO KToken) {
        String url = KAUTH_USER_URL_HOST+"v2/user/me";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+KToken.getAccessToken());
        HttpEntity<String> request = new HttpEntity<>(headers);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<KakaoVO> response = restTemplate.exchange(
            url, 
            HttpMethod.POST, 
            request, 
            KakaoVO.class
        );
        KakaoVO kakaoRes = response.getBody();
        System.out.println(kakaoRes);
        return kakaoRes;
    }
    
}

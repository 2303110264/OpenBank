package kopo.aisw.hc.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

//@Component
//@ComponentScan(value = "application-API-KEY.properties")
@Configuration
@PropertySource("classpath:application-API-KEY.properties")
@ComponentScan(basePackages ="kopo.aisw.hc")
public class ApiConfig {
	
	@Value("${JUSO}")
	private String juso;
	
	@Value("${KAKAO}")
	private String kakao;
	
	@Bean
	public Api api() {
		Api api = new Api();
		api.setJuso(juso);
		api.setKakao(kakao);
		return api;
	}
	
}
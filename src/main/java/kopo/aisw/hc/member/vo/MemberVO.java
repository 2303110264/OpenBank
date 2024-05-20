package kopo.aisw.hc.member.vo;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberVO {
	/*
	사용자식별코드 CUSTOMER_ID VARCHAR2(100)
	사용자 ID	USER_ID	VARCHAR2(20)
	비밀번호	PASSWORD	VARCHAR2(256)
	결제 비밀번호	CREDIT_PASSWORD	VARCHAR2(256)
	이름	NAME	VARCHAR2(15)
	휴대폰번호	PHONE_NUM	VARCHAR2(13)
	이메일	EMAIL	VARCHAR2(40)
	우편번호	ZIP_CODE	NUMBER(5)
	주소	ADDRESS	VARCHAR2(300)
	주민번호	RRN	NUMBER(13)
	고객 유형	CUSTOMER_TYPE	NUMBER(3)
	 
	 */
	private int customerId;
	@NotBlank(message = "아이디를 입력해주세요")
	@Size(min=3, message="아이디는 6~16자 사이만 가능합니다.")
	@Pattern(regexp = "\"^[a-z-_]{3,50}$\"", 
	message="아이디는 영어 소문자와 -또는 _로만 이루어져야 합니다.")
	private String userId;
	@NotBlank(message = "비밀번호를 입력해주세요")
	@JsonIgnore
	@Pattern(regexp ="^(?=.*[a-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]$", 
	message = "영문 소문자, 숫자, 특수문자(~!@#$%^&*()+|=])가 모두 포함되어야 합니다.")
	private String password;
	@JsonIgnore
	private String creditPassword;
	private String name;
	@Pattern(regexp="\"^[\\d]$\"")
	private String phoneNum;
	@Email
	private String email;
	private int zipCode;
	private String address;
	private String addressDetail; //상세주소
	private String rrn;
	private int customerType;
	private int availableBalance;
}

package kopo.aisw.hc.member.vo;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
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
	private String customerId;
	@NotBlank(message = "아이디를 입력해주세요")
	@Size(min=3, message="아이디는 6~16자 사이만 가능합니다.")
	private String userId;
	private String password;
	private String creditPassword;
	private String name;
	private String phoneNum;
	private String email;
	private int zipCode;
	private String address;
	private int rrn;
	private int customerType;
}

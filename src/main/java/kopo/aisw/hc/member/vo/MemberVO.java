package kopo.aisw.hc.member.vo;

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
	결제 비밀번호	CREDIT_PASSWORD	VARCHAR2(256)
	이름	NAME	VARCHAR2(18)
	휴대폰번호	PHONE_NUM	VARCHAR2(13)
	고객 유형	CUSTOMER_TYPE	NUMBER(3)
	 
	 */
	private long customerId;
	
	@Size(min=6, max=6, message="결제 비밀번호를 입력해주세요")
	private String creditPassword;
	
	@Size(min=1, max=6, message="이름을 입력해주세요(최대 6자)")
	private String name;
	
	@Pattern(regexp="^[\\d]{10,11}$", message = "전화번호를 입력해주세요")
	private String phoneNum;
	
	@Pattern(regexp="^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$", message = "메일 형식이 아닙니다.")
	private String email;
	
	//0: 일반 사용자, 1: 관리자, 999:거래정지
	private int customerType;
	private int availableBalance;
	private String regDate;
}

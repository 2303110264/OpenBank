package kopo.aisw.hc.product.vo;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
	CREATE TABLE TEST_PRODUCT_LIST(
	PRODUCT_NUM NUMBER(3) PRIMARY KEY
--	, PRODUCT_TYPE VARCHAR2(30) NOT NULL --예적금/대출 >> 예금/대출을 같은 테이블에서 관리 불가
	, PRODUCT_TARGET NUMBER(1) NOT NULL --가입대상 개인 및 법인(단체)
	, PRODUCT_NAME VARCHAR2(30) NOT NULL --상품명
	, DESCRIPTION VARCHAR2(600) NOT NULL --상품설명
	, INTEREST_RATE NUMBER(5,4) NOT NULL --금리
	, INITIAL_DEPOSIT NUMBER(15) NOT NULL --가입금액 또는 대출한도 >> 가입금액
	, DATE_OF_DEPOSIT NUMBER(2) NOT NULL --가입기간
--	, AVAILABLE DATE DEFAULT sysdate NOT NULL --신규가입 한도일자
	, AVAILABLE NUMBER(1) NOT NULL --신규가입 가능여부
	);
*/

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductVO {
	
	private int productNum;
    private int productTarget;
    private String productName;
    private String description;
    private double interestRate;
    private long initialDeposit;
    private int dateOfDeposit;
    private int available;
}

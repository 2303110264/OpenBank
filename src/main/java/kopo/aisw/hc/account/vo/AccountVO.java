package kopo.aisw.hc.account.vo;

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
public class AccountVO {
	/**
		ACC_NUM	NUMBER PRIMARY KEY
		ACC_NAME VARCHAR2(30) NOT NULL
		PRODUCT_NUM NUMBER(2) NOT NULL
		CUSTOMER_NAME VARCHAR2(18) NOT NULL
		CUSTOMER_ID NUMBER(8) NOT NULL
		INTEREST_RATE NUMBER(5,4) NOT NULL
		BALANCE NUMBER(15) NOT NULL
		REG_DATE DATE DEFAULT sysdate NOT NULL
		RET_DATE DATE NOT NULL
		LAST_TRADE_DATE DATE NOT NULL
		CONSTRAINT FK_CUSTOMER_ID FOREIGN KEY(CUSTOMER_ID) REFERENCES TEST_CUSTOMER(CUSTOMER_ID)
		CONSTRAINT FK_PRODUCT_NUM FOREIGN KEY(PRODUCT_NUM) REFERENCES TEST_PRODUCT_LIST(PRODUCT_NUM)
	 */
	//계좌번호 어떻게 구현하지
	@Size(min=13)
	private double accNum;
	private String accName;
	private int productNum;
	private int customerId;
	private float interestRate;
	private int balance;
	private String regDate;
	private String retDate;
	private String lastTradeDate;
	
}

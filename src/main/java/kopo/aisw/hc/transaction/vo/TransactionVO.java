package kopo.aisw.hc.transaction.vo;

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
public class TransactionVO {
	/**
		TRANSACTION_ID NUMBER PRIMARY KEY
		TRANSACTION_TYPE VARCHAR2(30) NOT NULL
		TRANSACTION_TIME DATE NOT NULL
		AMOUNT NUMBER(9) NOT NULL
		DEPOSIT_ACC NUMBER NOT NULL --입금
		DEPOSIT_NAME VARCHAR2(21) NOT NULL
		WITHDRAW_ACC NUMBER NOT NULL --출금
		WITHDRAW_NAME VARCHAR2(21) NOT NULL
		--CONSTRAINT FK_WITHDRAW_ACC FOREIGN KEY(WITHDRAW_ACC) REFERENCES TEST_ACCOUNT(ACC_NUM)
		--CONSTRAINT FK_DEPOSIT_ACC FOREIGN KEY(DEPOSIT_ACC) REFERENCES TEST_ACCOUNT(ACC_NUM)
	 */
	private int transactionId;
	private String transactionType;
	private String transactionDate;
	private int amount;
	private double depositAcc;
	private String depositName;
	private double withdrawAcc;
	private String withdrawName;
	
}

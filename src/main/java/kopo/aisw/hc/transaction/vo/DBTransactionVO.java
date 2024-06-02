package kopo.aisw.hc.transaction.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DBTransactionVO {
	/**
	TRANSACTION_ID NUMBER PRIMARY KEY
	TRANSACTION_TYPE VARCHAR2(6) NOT NULL
	TRANSACTION_DATE DATE NOT NULL
	ACC_NUM
	CUSTOMER_ID
	TRAN_NAME VARCHAR2(21) NOT NULL
	AMOUNT NUMBER(9) NOT NULL
 */
	private int tranNum;
	private String tranDate;
	private int tranType;
	private long accNum;
	private int custId;
	private String tranName;
	private int amount;
}

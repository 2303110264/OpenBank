package kopo.aisw.hc.transaction.vo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
	@NotNull(message="필수 항목입니다")
	private String transactionType;
	@NotNull
	private String transactionDate;
	@Min(value = 500, message="500원 이상부터 송금 가능합니다")
	@Max(value = 999999999, message="1000000000원 이상은 송금할 수 없습니다.")
	private long amount;
	@NotNull(message="필수 항목입니다")
	private long depositAcc;
	@Size(max=7, message="이름은 7자 이하로 정해주세요")
	@Pattern(regexp = "^[가-힣a-zA-Z]{0,7}$", message="한글, 영어 대소문자만 가능합니다")
	private String depositName;
	@NotNull
	private long withdrawAcc;
	private String withdrawName;
	
}

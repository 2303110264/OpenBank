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
public class DBTransactionVO {
	/**
  	TRANSACTION_ID NUMBER PRIMARY KEY
	TRANSACTION_TYPE VARCHAR2(8) NOT NULL
	TRANSACTION_DATE TIMESTAMP NOT NULL
	ACC_NUM NUMBER NOT NULL
	TRAN_NAME VARCHAR2(21) NOT NULL
	AMOUNT NUMBER(9) NOT NULL
	AFTER_BALANCE NUMBER(21,2) NOT NULL
	CONSTRAINT FK_ACC_NUM FOREIGN KEY(ACC_NUM) REFERENCES CB_ACCOUNT(ACC_NUM)
);
 */
	private int transactionId;
	
	@Size(min=1)
	private String tranType; 
	//입금 출금 이체? 이체일 경우 pivot을 사용할 수 없음. 
	// Q. 이체여부를 따로 컬럼으로 분리해야하는가?
	// 		단순 출금과 이체를 분리할 이유가 있는가? -> 추후 분리해도 지장이 없을 것.
	
	private String tranDate;
	
	@NotNull(message="필수 항목입니다")
	private long accNum;
	
	@Size(max=7, message="이름은 7자 이하로 정해주세요")
	@Pattern(regexp = "^[가-힣a-zA-Z]{0,7}$", message="한글, 영어 대소문자만 가능합니다")
	private String tranName;

	@Min(value = 500, message="500원 이상부터 송금 가능합니다")
	@Max(value = 999999999, message="1000000000원 이상은 송금할 수 없습니다.")
	private int amount;
	
	//받을땐 소수점 자르고 long으로 받음 
	// long 최대값 (9223372036854775807)
	//Max value는 인식을 못함... 숫자가 너무 크대
	private long afterBalance;
	
}

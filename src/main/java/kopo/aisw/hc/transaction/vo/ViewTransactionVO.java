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
public class ViewTransactionVO {
	
	private int transactionId;
	private String transactionType;
	private String transactionDate;
	private long amount;
	private long depositAcc;
	private String depositName;
	private long withdrawAcc;
	private String withdrawName;
	
}

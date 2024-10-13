package kopo.aisw.hc.transaction.vo;

import java.util.List;

import kopo.aisw.hc.member.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransactionResponseVO {
	private String bank_code;
	private int page;
	private String accNum;
	private MemberVO member;
	private int page_record_cnt;
	private long amount;
	private List<TransactionVO> transaction;
}

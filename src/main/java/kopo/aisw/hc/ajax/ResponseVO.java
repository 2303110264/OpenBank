package kopo.aisw.hc.ajax;

import kopo.aisw.hc.member.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {
	private int responseCode;
	private MemberVO member;
	private String responseString;
}

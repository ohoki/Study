package co.micol.notice.member.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String memberTel;
	private String memberGender;
}

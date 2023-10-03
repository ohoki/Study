package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class MemberDAO extends DAO {
	private static MemberDAO memberDao = null;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if(memberDao == null) {
			memberDao = new MemberDAO();
		}
		return memberDao;
	}
	
	//로그인 기능
	public Member login(String id) {
		Member member = null;
		
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberAuth(rs.getString("member_auth"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}
	
	//고객 계좌 정보 조회
	public List<Member> getAccountInfo() {
		List<Member> list = new ArrayList<>();
		Member member = null;
		
		try {
			conn();
			String sql = "SELECT a.member_id, a.account_id, a.account_balance, m.member_name, m.member_auth FROM account a JOIN member m \r\n"
					+ "ON a.member_id = m.member_id WHERE a.member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setAccountId(rs.getString("account_id"));
				member.setAccountBallance(rs.getInt("account_balance"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberAuth(rs.getString("member_auth"));
				list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
}

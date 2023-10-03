package yhBank.member;

import java.util.List;
import java.util.Scanner;

import yhBank.account.AccountService;

public class MemberService {
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);
	AccountService as = new AccountService();
	
	//로그인
	public void login() {
		Member member = null;
		
		System.out.println("ID를 입력해주세요>");
		member = MemberDAO.getInstance().login(sc.nextLine());
		
		if(member != null) {
			while(true) {
				System.out.println("PW를 입력해주세요>");
				if(member.getMemberPw().equals(sc.nextLine())) {
					memberInfo = member;
					System.out.println("로그인 되었습니다.");
					System.out.println(member.getMemberId() + "님 반갑습니다.");
					break;
				} else {
					System.out.println("PW가 다릅니다. 다시 입력해주세요.");
				}
			}
		} else {
			System.out.println("존재하지 않는 ID 입니다.");
		}
	}
	
	//회원가입
	public void insertMember() {
		Member member = new Member();
		String id = "";
		
		System.out.println("회원가입을 시작합니다.");
		//ID 입력
		while(true) {
			System.out.println("ID를 입력해주세요>");
			id = sc.nextLine();
			
			//중복 확인
			Member confirmMember = MemberDAO.getInstance().selectMember(id);
			if(confirmMember != null) {
				System.out.println("이미 사용 중인 ID 입니다. 다른 ID를 입력해주세요.");
			} else {
				System.out.println("사용 가능한 아이디 입니다.");
				System.out.println("1. 사용하기  | 2. 다시 입력하기");
				int selectNo = Integer.parseInt(sc.nextLine());
				
				if(selectNo == 1) {
					member.setMemberId(id);
					System.out.println("입력되었습니다.");
					break;
				}else if(selectNo == 2) {
					continue;
				}else {
					System.out.println("잘못된 입력입니다. 숫자 1과 2 중 하나만 입력해주세요.");
				}
			}
		}
		//다른 정보 입력
		System.out.println("비밀번호를 입력해주세요>");
		member.setMemberPw(sc.nextLine());
		
		System.out.println("이름을 입력해주세요>");
		member.setMemberName(sc.nextLine());
		
		System.out.println("연락처를 입력해주세요>");
		member.setMemberPhone(sc.nextLine());
		
		System.out.println("주소를 입력해주세요>");
		member.setMemberAddr(sc.nextLine());
		
		System.out.println("보물 1호는 무엇인가요?>");
		System.out.println("❗❗❗❗❗❗❗❗ 계정 분실 시 필요하니 꼭 기억해두세요~ ❗❗❗❗❗❗❗❗");
		member.setMemberAnswer(sc.nextLine());
		
		int result = MemberDAO.getInstance().insertMember(member);
		
		if(result > 0) {
			System.out.println("정상 등록 되었습니다.");
		} else {
			System.out.println("회원 등록에 실패했습니다.");
		}
	}
	
	// 찾기
	public void find() {
		System.out.println(" 1. ID 찾기   | 2. PW 찾기 | 3. 뒤로가기");
		int selectNo = Integer.parseInt(sc.nextLine());
		
		if(selectNo == 1) {
			//아이디 찾기
			System.out.println("이름을 입력해주세요>");
			String name = sc.nextLine();
			
			System.out.println("휴대폰 번호를 입력해주세요>");
			String phone = sc.nextLine();
			
			System.out.println("가입할 때 입력하신 질문의 정답을 입력해주세요>");
		    System.out.println("보물 1호는 무엇인가요?>");
			String answer = sc.nextLine();
			
			Member result = MemberDAO.getInstance().findId(name, phone, answer);
			
			if(result != null) {
				System.out.println(result.getMemberName() + "님의 ID는 " + result.getMemberId() + " 입니다.");
			} else {
				System.out.println("해당 ID를 찾을 수 없습니다.");
			}
		}else if(selectNo == 2) {
			//비밀번호 찾기
			System.out.println("ID를 입력해주세요>");
			String id = sc.nextLine();
			
			System.out.println("가입할 때 입력하신 질문의 정답을 입력해주세요>");
		    System.out.println("보물 1호는 무엇인가요?>");
			String answer = sc.nextLine();
			
			Member result = MemberDAO.getInstance().findPw(id, answer);
			
			if(result != null) {
				System.out.println(result.getMemberId() + "님의 PW는 " + result.getMemberPw() + " 입니다.");
			} else {
				System.out.println("해당 PW를 찾을 수 없습니다.");
			}
		}else if(selectNo == 3) {
			System.out.println("✔");
		}else {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
		}
	}	
	
	//내 정보 찾기
	public void selectMember( ) {
		System.out.println("내 정보를 불러옵니다.");
		Member member = MemberDAO.getInstance().selectMember(MemberService.memberInfo.getMemberId());
		String auth = "";
		
		if(member.getMemberAuth().equals("N")) {
			auth = "일반 회원";
		}else if(member.getMemberAuth().equals("V")) {
			auth = "특별 회원";
		}else if(member.getMemberAuth().equals("A")) {
			auth = "관리자";
		}
		System.out.println(member.getMemberName());
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPw());
		System.out.println(member.getMemberPhone());
		System.out.println(member.getMemberAddr());
		System.out.println(auth);
	}
	
	//정보수정
	public void updateMember() {
		int result = 0;
		int selectNum = 0;
		System.out.println("변경할 정보를 선택해 주세요.");
		try {
			System.out.println("1. 이름   | 2. 전화번호   | 3. 주소   | 4. 비밀번호");
			selectNum = Integer.parseInt(sc.nextLine());
			if(selectNum == 1) {
				System.out.println("변경할 이름을 입력해주세요>");
				memberInfo.setMemberName(sc.nextLine());
			}else if(selectNum == 2) {
				System.out.println("변경할 전화번호를 입력해주세요>");
				memberInfo.setMemberPhone(sc.nextLine());
			}else if(selectNum == 3) {
				System.out.println("변경할 주소를 입력해주세요>");
				memberInfo.setMemberAddr(sc.nextLine());
			}else if(selectNum == 4) {
				System.out.println("변경할 비밀번호를 입력해주세요>");
				memberInfo.setMemberPw(sc.nextLine());
			}else {
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		} catch(Exception e) {
			System.out.println("메뉴를 다시 선택해 주세요.");
		}
		result = MemberDAO.getInstance().updateMember(memberInfo, selectNum);
		if(result > 0) {
			System.out.println("정보가 변경되었습니다.");
		} else {
			System.out.println("정보 변경에 실패했습니다.");
		}
	}
}

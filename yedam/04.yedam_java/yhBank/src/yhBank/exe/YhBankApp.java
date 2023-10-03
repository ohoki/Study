package yhBank.exe;

import java.util.Scanner;

import yhBank.member.AdminApp;
import yhBank.member.MemberApp;
import yhBank.member.MemberService;

public class YhBankApp {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	
	public YhBankApp() {
		AppStart();
	}

	private void AppStart() {
		System.out.println("반갑습니다.");
		System.out.println("yhBank에 오신걸 환영합니다~🎉🎉\n");
		
		while(true) {
			try {
				if(MemberService.memberInfo == null) {
					System.out.println("1. 로그인   | 2. 회원 가입   | 3. ID/PW 찾기   | 4. 종료하기");
					
					int selectNum = Integer.parseInt(sc.nextLine());
					
					if(selectNum == 1) {
						ms.login();
					}else if(selectNum == 2) {
						ms.insertMember();
					}else if(selectNum == 3) {
						ms.find();
					}else if(selectNum == 4) {
						System.out.println("이용해주셔서 감사합니다.😉");
						break;
					}else {
						System.out.println("메뉴를 다시 선택해주세요.");
					}
				} else {
					if(MemberService.memberInfo.getMemberAuth().equals("A")) {
						new AdminApp();
					} else{
						new MemberApp();
					}
				}
			} catch(Exception e) {
				System.out.println("메뉴를 다시 선택해 주세요.");
			}
		}
	}
}

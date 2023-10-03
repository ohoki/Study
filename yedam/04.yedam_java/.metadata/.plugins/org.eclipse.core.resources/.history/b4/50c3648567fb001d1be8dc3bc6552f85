package yhBank.member;

import java.util.Scanner;

import yhBank.account.AccountApp;
import yhBank.account.BankingApp;
import yhBank.board.BoardApp;

public class MemberApp {
	Scanner sc = new Scanner(System.in);
	
	public MemberApp() {
		start();
	}

	private void start() {
		while(true) {
			try {
				System.out.println("1. 내 정보   | 2. 계좌 관리  | 3. 뱅킹   | 4. 민원 게시판   | 5. 로그아웃");
				
				int selectNum = Integer.parseInt(sc.nextLine());
				if(selectNum == 1) {
					new myInformation();
				}else if(selectNum == 2) {
					new AccountApp();
				}else if(selectNum == 3) {
					new BankingApp();
				}else if(selectNum == 4) {
					new BoardApp();
				}else if(selectNum == 5) {
					MemberService.memberInfo = null;
					System.out.println("이용해주셔서 감사합니다.😉");
					break;
				}else {
					System.out.println("메뉴를 다시 선택해주세요.");
				}
			} catch(Exception e) {
				System.out.println("메뉴를 다시 선택해 주세요.");
			}
		}
	}
}

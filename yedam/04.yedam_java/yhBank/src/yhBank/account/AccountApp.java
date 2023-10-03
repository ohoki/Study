package yhBank.account;

import java.util.Scanner;

public class AccountApp {
	Scanner sc = new Scanner(System.in);
	AccountService as = new AccountService();
	
	public AccountApp() {
		start();
	}

	private void start() {
		while(true) {
			try {
				System.out.println("1. 계좌 개설 | 2. 계좌 해지   | 3. 계좌 조회   | 4. 뒤로가기");
				
				int selectNum = Integer.parseInt(sc.nextLine());
				
				if(selectNum == 1) {
					as.insertAccount();
				}else if(selectNum == 2) {
					as.deleteAccount();
				}else if(selectNum == 3) {
					as.checkAccount();
				}else if(selectNum == 4) {
					System.out.println("✔");
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

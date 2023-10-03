package yhBank.account;

import java.util.Scanner;

public class BankingApp {
	Scanner sc = new Scanner(System.in);
	AccountService as = new AccountService();
	
	public BankingApp() {
		start();
	}

	private void start() {
		while(true) {
			try {
				System.out.println("1. 계좌 이체 | 2. 입금 및 출금   | 3. 환율 조회   | 4. 환전   | 5. 자동이체   | 6. 뒤로가기");
				
				int selectNum = Integer.parseInt(sc.nextLine());
				
				if(selectNum == 1) {
					as.transferMoney();
				}else if(selectNum == 2) {
					as.inOutMoney();
				}else if(selectNum == 3) {
					
				}else if(selectNum == 4) {
					
				}else if(selectNum == 5) {
					
				}else if(selectNum == 6) {
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

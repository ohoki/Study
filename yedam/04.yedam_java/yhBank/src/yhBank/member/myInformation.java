package yhBank.member;

import java.util.Scanner;

public class myInformation {
	MemberService ms = new MemberService();
	Scanner sc = new Scanner(System.in);
	
	public myInformation() {
		start();
	}

	private void start() {
		while(true) {
			try {
				System.out.println("1. 내 정보 조회   | 2. 내 정보 수정   | 3. 뒤로가기");
				
				int selectNum = Integer.parseInt(sc.nextLine());
				if(selectNum == 1) {
					ms.selectMember();
				}else if(selectNum == 2) {
					ms.updateMember();
				}else if(selectNum == 3) {
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

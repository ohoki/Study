package com.yedam.exe;

import java.util.Scanner;

public class StoreApp {
	Scanner sc = new Scanner(System.in);
	boolean run = true;
	StoreService ss = new StoreService();
	
	public StoreApp() {
		start();
	}

	private void start() {
		while(run) {
			System.out.println("=============================================================================");
			System.out.println("1. 모든 가게 정보 조회 | 2. 지역구별 매출 합계 | 3. 가게 정보 입력 | 4. 매출 수정 | 5. 종료");
			System.out.println("=============================================================================");
			
			System.out.println("메뉴를 선택해 주세요>");
			int selectMenu = Integer.parseInt(sc.nextLine());
			
			switch(selectMenu) {
			case 1 :
				ss.getStores();
				break;
			case 2 :
				ss.getStoreSales();
				break;
			case 3 :
				ss.insertStore();
				break;
			case 4 :
				ss.updateSales();
				break;
			case 5 :
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}

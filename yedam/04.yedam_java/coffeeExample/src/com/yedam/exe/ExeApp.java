package com.yedam.exe;

import java.util.Scanner;

import com.yedam.coffee.CoffeeService;

public class ExeApp {
	Scanner sc = new Scanner(System.in);
	String menuNo = null;
	CoffeeService cs = new CoffeeService();
	
	public ExeApp() {
		start();
	}

	private void start() {
		while(true) {
			menu();
			
			if(menuNo.equals("1")) {
				cs.getCoffes();
			}else if(menuNo.equals("2")) {
				cs.getCoffee();
			}else if(menuNo.equals("3")) {
				cs.insertCofee();
			}else if(menuNo.equals("4")) {
				cs.sellCoffee();
			}else if(menuNo.equals("5")) {
				cs.deleteCoffee();
			}else if(menuNo.equals("6")) {
				cs.totalSales();
			}else if(menuNo.equals("7")) {
				System.out.println("end of prog");
				break;
			}else {
				System.out.println("다시 선택해 주세요.(1~7)");
			}
		}	
	}
	
	private void menu() {
		System.out.println("1. 메뉴 조회 | 2. 메뉴 상세 조회 | 3. 메뉴 등록 | 4. 판매 | 5. 메뉴 삭제 | 6. 매출 | 7. 종료");
		System.out.println("메뉴 입력>");
		
		menuNo = sc.nextLine();
	}
}

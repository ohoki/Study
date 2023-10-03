package com.yedam.coffee;

import java.util.List;
import java.util.Scanner;

public class CoffeeService {
	Scanner sc = new Scanner(System.in);
	
	//전체 조회
	public void getCoffes() {
		List<Coffee> list = CoffeeDAO.getInstance().getCoffes();
	
		for(int i=0; i<list.size(); i++) {
			System.out.println("메뉴 : " + list.get(i).getCoffeeMenu() + " 가격 : " + list.get(i).getCoffeePrice());
		}
	}
		
	//단건 조회
	public void getCoffee() {
		System.out.println("메뉴 입력>");
		String coffe = sc.nextLine();
		Coffee cf = CoffeeDAO.getInstance().getCoffee(coffe);
		
		if(cf != null) { //데이터가 조회가 되었을 경우
			System.out.println("메뉴 : " + cf.getCoffeeMenu() + " 가격 : " + cf.getCoffeePrice() + " 설명 : " + cf.getCoffeeExplain() );
		}else { //데이터가 조회 되지 않은 경우
			System.out.println("존재하지 메뉴 입니다.");
		}
	}
	
	//등록
	public void insertCofee() {
		Coffee cf = new Coffee();
		
		System.out.println("메뉴 입력>");
		cf.setCoffeeMenu(sc.nextLine());
		
		System.out.println("가격 입력>");
		cf.setCoffeePrice(Integer.parseInt(sc.nextLine()));
		
		System.out.println("설명 입력>");
		cf.setCoffeeExplain(sc.nextLine());

		int result = CoffeeDAO.getInstance().insertCoffee(cf);
		
		if(result > 0) {
			System.out.println("메뉴 등록 완료");
		} else {
			System.out.println("메뉴 등록 실패");
		}
	}
	
	//판매
	public void sellCoffee() {
		System.out.println("메뉴 입력>");
		
		String coffee = sc.nextLine();
		
		int result = CoffeeDAO.getInstance().sellCoffee(coffee);
		
		if(result > 0) {
			System.out.println("판매량 완료");
		} else {
			System.out.println("판매량 실패");
		}
	}
	
	//삭제
	public void deleteCoffee() {
		System.out.println("메뉴 입력>");
		
		String coffee = sc.nextLine();
		
		int result = CoffeeDAO.getInstance().deleteCoffee(coffee);
		
		if(result > 0) {
			System.out.println("메뉴 삭제 완료");
		} else {
			System.out.println("메뉴 삭제 실패");
		}
	}
	
	//매출
	public void totalSales() {
		List<Coffee> list = CoffeeDAO.getInstance().totalSales();
		int sum = 0;
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("메뉴 : " + list.get(i).getCoffeeMenu() + " 판매갯수 : " + list.get(i).getCoffeeSales() + "개 판매 금액 : " + (list.get(i).getTotalSales() + "원"));
			sum += list.get(i).getTotalSales();
		}
		System.out.println("총 매출액 : " + sum + "원");
	}
}

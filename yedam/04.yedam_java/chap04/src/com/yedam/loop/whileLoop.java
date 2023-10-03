package com.yedam.loop;

import java.util.Scanner;

public class whileLoop {

	public static void main(String[] args) {
		// while 문 ================================================================
		int i = 1;
		while(i<=100) {
			if(i%2 == 0) {
				System.out.println(i);
			}
			i++;
		}
		
		//계산기 프로그램
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 종료");
			System.out.println("입력>");
			
			int num = Integer.parseInt(scanner.nextLine());
			
			switch(num) {
			case 1 :
				System.out.println("더하고 싶은 두 수를 입력하시오");
				System.out.println("1>");
				int num1 = Integer.parseInt(scanner.nextLine());
				System.out.println("2>");
				int num2 = Integer.parseInt(scanner.nextLine());
				System.out.println("결과는"+ (num1+num2));
				break;
			case 2 :
				System.out.println("빼고 싶은 두 수를 입력하시오");
				System.out.println("1>");
				int num3 = Integer.parseInt(scanner.nextLine());
				System.out.println("2>");
				int num4 = Integer.parseInt(scanner.nextLine());
				System.out.println("결과는"+ (num3-num4));
				break;
			case 3 :
				System.out.println("빼고 싶은 두 수를 입력하시오");
				System.out.println("1>");
				int num5 = Integer.parseInt(scanner.nextLine());
				System.out.println("2>");
				int num6 = Integer.parseInt(scanner.nextLine());
				System.out.println("결과는"+ (num5*num6));
				break;
			case 4 :
				System.out.println("종료합니다.");
				run = false;
				break;
			}
		}
		
		//오락실 만들기 (1회 500원)
		
		System.out.println("===insert coin===");
		int money = Integer.parseInt(scanner.nextLine());
		
		while(money > 500) {
			System.out.println( (money/500)+ "번 기회 남았습니다." );
			System.out.println("1. 가위바위보 | 2. UP&DOWN | 3. 종료");
			
			System.out.println("메뉴입력>");
			int gameNo = Integer.parseInt(scanner.nextLine());
			
			switch(gameNo) {
			case 1:
				System.out.println("가위바위보 진행");
				money -= 500;
				break;
			case 2:
				System.out.println("UP&DOWN 진행");
				money -= 500;
				break;
			case 3:
				System.out.println("프로그램 종료");
				money = 0;
				break;
			}
		}
	}
}

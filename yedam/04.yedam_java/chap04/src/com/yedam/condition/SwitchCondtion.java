package com.yedam.condition;

import java.util.*;

public class SwitchCondtion {

	public static void main (String[] args) {
		//int
		int dice = (int)(Math.random()*6) + 1;
		switch(dice) {
		case 1 :
			System.out.println("주사위 눈 1");
			break;
		case 2 :
			System.out.println("주사위 눈 2");
			break;
		case 3 :
			System.out.println("주사위 눈 3");
			break;
		case 4 :
			System.out.println("주사위 눈 4");
			break;
		case 5 :
			System.out.println("주사위 눈 5");
			break;
		case 6 :
			System.out.println("주사위 눈 6");
			break;
		}
		//String
		String grade = "b";
		switch(grade) {
		case "A" :
			System.out.println("우수회원");
			break;
		case "B" :
		case "b" :	
			System.out.println("일반회원");
			break;
		default :
			System.out.println("손님");
			break;
		}
		//입력한 성적을 등급으로 표현
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("성적입력>");
		int score = Integer.parseInt(scanner.nextLine());
		
		switch(score/10) {
		case 10 :
		case 9 :
			if(score >= 95) {
				System.out.println("등급 A+");
			} else {
				System.out.println("등급 A");
			}
			break;
		case 8 :
			if(score >= 85) {
				System.out.println("등급 B+");
			} else {
				System.out.println("등급 B");
			}
			break;
		case 7 :
			if(score >= 75) {
				System.out.println("등급 C+");
			} else {
				System.out.println("등급 C");
			}
			break;
		default :
			System.out.println("등급 D");
			break;
		}
		
		//메뉴 선택
		System.out.println("1. 글 보기 2. 글 수정 3. 글 삭제 4. 뒤로가기");
		int selectNo = Integer.parseInt(scanner.nextLine());
		
		switch (selectNo) {
		case 1:
			System.out.println("글 보는 기능");
			break;
		case 2:
			System.out.println("글 수정하는 기능");
			break;
		case 3:
			System.out.println("글 삭제하는 기능");
			break;
		case 4:
			System.out.println("뒤로 가는 기능");
			break;
		}
	}
}
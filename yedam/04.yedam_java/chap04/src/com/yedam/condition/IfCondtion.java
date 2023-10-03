package com.yedam.condition;

import java.util.*;

public class IfCondtion {

	public static void main (String[] args) {
		int score = 93;
		
		//if문===================================================================================================
		if(score >= 90) {
			System.out.println("점수가 90이상이고 등급 A");
		}
		//if-else
		if(score >= 90) {
			System.out.println("점수가 90이상임");
		} else {
			System.out.println("점수가 90미만임");
		}
		//else-if 문
		if(score >= 90) {
			System.out.println("등급 A");
		} else if(score >= 80) {
			System.out.println("등급 B");
		} else if(score >= 70) {
			System.out.println("등급 C");
		} else if(score >= 60) {
			System.out.println("등급 D");
		} else {
			System.out.println("등급 F");
		}
		
		//random() 값 추출 -> Random() / Math.random()==========================================================
		// 0 <= Math.random() < 1 ( Math.random() -> 0 ~ 0.9xxxx 의 실수 값을 출력함)
		//1부터 10까지의 랜덤한 정수 -> (int)(Math.random()*10)+1
		int dice = (int)(Math.random()*6) + 1;
		if(dice == 1) {
			System.out.println("주사위 눈 1");
		} else if(dice == 2) {
			System.out.println("주사위 눈 2");
		} else if(dice == 3) {
			System.out.println("주사위 눈 3");
		} else if(dice == 4) {
			System.out.println("주사위 눈 4");
		} else if(dice == 5) {
			System.out.println("주사위 눈 5");
		} else {
			System.out.println("주사위 눈 6");
		}
		
		//중첩 if ==============================================================================================
		int no = 10;
		if ( no%2 == 0 ) {
			if (no%5 == 0) {
				System.out.println("2의 배수, 5의 배수");
			}
		}
		
		String grade;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("점수 입력>");
		score = Integer.parseInt(scanner.nextLine());
		
		if( score >= 90) {
			if ( score >= 95) {
				grade = "A+" ;
			} else {
				grade = "A";
			}
		} else {
			System.out.println("범위 밖입니다.");
		}
	}
}
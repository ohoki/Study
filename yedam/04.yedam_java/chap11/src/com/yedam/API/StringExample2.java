package com.yedam.API;

import java.util.Scanner;

public class StringExample2 {
	public static void main(String[] args) {
		//1) 문자열 뒤집기
		String str = "abcdefg";
		String newStr = "";
		
		for(int i=0; i<str.length(); i++) {
			newStr += str.charAt(str.length()-i-1);
		}
		
		System.out.println(newStr);
		
		//2) 문자 개수 찾기
		//숫자 : 6개 알파벳 : 7개 공백(띄워쓰기) : 1개
		String str2 = "1n2ASD 330naa1";
		
		int[] count = new int[3]; // 숫자, 알파벳, 공백 개수 세기위한 배열
		
		for(int i=0; i<str2.length(); i++) {
			if('0'<=str2.charAt(i) && str2.charAt(i)<='9') {
				count[0]++;
			} else if( ('a' <= str2.charAt(i) && str2.charAt(i) <= 'z') || 
					   ('A' <= str2.charAt(i) && str2.charAt(i) <= 'Z') ) {
				count[1]++;
			} else if(str2.charAt(i) == ' ') {
				count[2]++;
			}
		}
		
		System.out.println("숫자 : " + count[0] + " 알파벳 : " + count[1] + " 공백 : " + count[2]);
		
		
		//3) 주민등록번호 입력 후 나이 계산하기
		//980102-1234567 -> 26세
		//00102-1234567 -> 24세
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주민등록번호를 입력해주세요( - 포함 ) >");
		String ssn = sc.nextLine();
		int age = 0;
		
		if(ssn.length() == 14) {
			int year = Integer.parseInt( ssn.substring(0,2) );
			if(24 <= year && year <= 99) {
				age = 123 - year + 1;
			} else {
				age = 23 - year +1;
			}
		} else {
			System.out.println("주민등록번호를 다시 입력해주세요");
		}
		
		System.out.println(age+"살");
		
		//4) 문자열 압축
		//결과 -> K2HS8E
		String str3 = "KKHSSSSSSSSE";
		char temp = str3.charAt(0);
		String newStr3 = "";
		int cnt = 1;
		
		for(int i=0; i<str3.length(); i++) {
			if(i == 0) {
				newStr3 += str3.charAt(i); 
			} else {
				if( str3.charAt(i) == temp ) {
					cnt++;
				} else {
					if( cnt != 1) {
						newStr3 += cnt;
					}
					newStr3 += str3.charAt(i);
					cnt = 1;
					temp = str3.charAt(i);
				}
			}
			
		}
		System.out.println(newStr3);
		
		//다른 버전
		newStr3 = "";
		
		for(int i=0; i<str3.length(); i++) {
			//&& 와 & 의 차이
			if( i < str3.length() -1 && (str3.charAt(i) == str3.charAt(i+1)) ) {
				cnt++;
			} else {
				newStr3 += str3.charAt(i);
				if(cnt > 1) {
					newStr3 += String.valueOf(cnt);
				}
				cnt = 1;
			}
		}
		System.out.println(newStr3);
		
	}
}

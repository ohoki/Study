package com.yedam.print;

import java.io.IOException;

import java.util.*;

public class KeyCode {

	public static void main(String[] args) throws IOException {
		//System.in.read() -> 하나의 문자만 받아 올 때=====================================
		System.out.println("입력>");
		
		int KeyCode = 0;
		
		KeyCode = System.in.read();
		System.out.println("KeyCode : " + KeyCode);
		
		KeyCode = System.in.read();
		System.out.println("KeyCode : " + KeyCode);
		
		KeyCode = System.in.read();
		System.out.println("KeyCode : " + KeyCode);
		//Enter 키 까지 데이터로 입력되서 출력됨'
		
		//Scanner======================================================================
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("입력>");
		
		//문자열 읽기
		//nextLine() => enter키 이전까지 데이터를 받아 옴
		String inputData = scanner.nextLine();
		//정수 읽기
		
		int data = scanner.nextInt();
		//nextInt() => enter키 이전까지 데이터를 받고 enter키를 유지함 (다음 데이터 출력 시 enter키가 입력되는 오류가 생김)
		// -> Integer.parseInt(nextLine())을 사용하도록 하자!!!
		inputData = scanner.nextLine();
		inputData = scanner.nextLine();
		System.out.println("Scanner 활용 => "+inputData);
		
		//데이터 비교=========================================================================
		
		//기본타입 ( == ), 문자열 ( equals )
		
		
		if( inputData.equals("yedam")) {
			System.out.println("yedam과 일치합니다.");
		}
	}

}

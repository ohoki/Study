package com.yedam.reference;

public class StringRef {

	public static void main(String[] args) {
		String strVal1 = "yedam";
		String strVal2 = "yedam";
		
		//두 문자열 주소값 비교
		if(strVal1 == strVal2) {
			System.out.println("strVal1과 strVal2는 메모리 주소 동일");
		} else {
			System.out.println("strVal1과 strVal2는 메모리 주소 다름");
		}
		//두 문자열 데이터 비교
		if(strVal1.equals(strVal2)) {
			System.out.println("strVal1과 strVal2는 메모리 주소 동일");
		} else {
			System.out.println("strVal1과 strVal2는 메모리 주소 다름");
		}
		//new 연산자를 활용해서 String의 새로운 객체 생성
		String strVal3 = new String("yedam");
		String strVal4 = new String("yedma");
		
		//객체간 주소 비교
		if(strVal3 == strVal4) {
			System.out.println("strVal3과 strVal4는 메모리 주소 동일");
		} else {
			System.out.println("strVal3과 strVal4는 메모리 주소 다름");
		}
		
		//객체간 데이터 비교
		if(strVal3.equals(strVal4)) {
			System.out.println("strVal3과 strVal4는 메모리 주소 동일");
		} else {
			System.out.println("strVal3과 strVal4는 메모리 주소 다름");
		}
	}

}

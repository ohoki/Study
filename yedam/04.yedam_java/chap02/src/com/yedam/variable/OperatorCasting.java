package com.yedam.variable;

public class OperatorCasting {

	public static void main(String[] args) {
		byte value1 = 10;
		int value2 = 100;
		long value3 = 1000;
		long result = value1 + value2 + value3;
		System.out.println(result);
		
		//실수와 정수 타입 변환
		int iValue1 = 10;
		int iValue2 = iValue1/4;
		System.out.println(iValue2);
		
		double dValue = iValue1/4.0;
		System.out.println(dValue);   //2.5
		
		int x = 1;
		int y = 2;
		double result2 = (double)x/y;
		System.out.println(result2);  //0.5
		
		//문자열 + 연산
		int value = 10+2+8;
		String str1 = 10+2+"8";
		System.out.println("str1 : " + str1);  //128
		
		String str2 = "10"+(2+8);
		System.out.println("str2 :" + str2);
		
		//String <-> 기본 타입 (정수, 실수, 논리) 변환
		int valueStr = Integer.parseInt(str2);
		short shortValue = Short.parseShort(str2);
		double doubleValue = Double.parseDouble(str2);
		System.out.println(doubleValue);	
		//		boolenan bValue = Boolean.parseBoolean(str2);
		
		//기본타입 -> String 변환
		String str3 = String.valueOf(valueStr);
		String str4 = String.valueOf(doubleValue);
		System.out.println(str3);
	}

}

package com.yedam.exception;

public class ExceptionExample {
	public static void main(String[] args) {
		
		//nullpointException
		String data = null;
		System.out.println(data.length()); 
		
		//ArrayIndexOutOfBoundsException
		int[] intAry = new int[3];
		
		intAry[0] = 1;
		intAry[10] = 10;
		
		//NumberFormatException -> 바꿀 수 없는 숫자인데 바꾸려고 할 때 
		String str = "자바";
		int val = Integer.parseInt(str);
		System.out.println(val);
		
		//ClassCastException
		Example exam = new Example();
		Exam exam04 = (Exam) exam;
		
		//ClassNotFoundException -> 클래스 파일을 찾지 못할 때, 실행 메소드(main)을 찾지 못할 때
		
		//ArithmeticException -> 분모가 0일 때 
		double a = 1/0;
		
		//IOException -> 입출력 오류 ( file reading / write )
		
		//FileNotFoundException -> 경로를 찾지 못해서 나는 오류
		
		//OutofMemoryError -> 메모리 부족할때 ( 메모리 누수, 부족 등 ) -> 무한 루프 등등..
	}
}

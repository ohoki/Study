package com.yedam.exception;

public class Application01 {

	public static void main(String[] args) {
		try {
			//예외가 발생할만한 코드
			double avg = 1/0;
			
			String str = "자바";
			int a = Integer.parseInt(str);
			
			Class clazz2 = Class.forName("java.lang.String2");
		}catch(ArithmeticException e) { 
			//예외, 문제가 발생했을 때 처리하는 코드
			System.out.println("숫자는 0으로 나누가 못함");
			e.printStackTrace();
		}catch(NumberFormatException e) {
			System.out.println("문자열 -> 정수 변환 불가능");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		// catch블록 작성 시 상위 예외 클래스가 하위 예외 클래스보다 아래에 위치해야한다
		finally {
			//try 또는 catch문 실행하고 나서 무조건 실행하는 코드
			System.out.println("finally는 항상 실행");
		}
		
		//throws
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}
	
	
}

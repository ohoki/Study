package com.yedam.variable;

public class Variable02 {

	public static void main(String[] args) {
		
		//진수=====================================================================
		int var1 = 0b1011; //2진수
		int var2 = 0206;   //8진수
		int var3 = 365;    //10진수
		int var4 = 0xB3;   //16진수

		System.out.println("var1 : " + var1);
		System.out.println("var2 : " + var2);
		System.out.println("var3 : " + var3);
		System.out.println("var4 : " + var4);
		
		//정수타입의 범위===============================================================
		//byte -> =128 ~ 127
		byte bvar1 = 126;
		//long
		long lvar1 = 2000000000000000000l;
		
		//char=====================================================================
		char c1 = 'A';
		char c2 = 65;
		char c3 = '\u0041'; //유니코드 표현
		char c4 = '가';
		char c5 = 44032;
		char c6 = '\uac00';
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
	
		//이스케이프 문자================================================================
		//문자열 String
		String name = "홍길동";
		String job = "프로그래머";
		/*      \t, \n, \\, \" 등    */
		
		System.out.println(name + "\t" + job);
		System.out.println("행 단위 출력 \n");
		System.out.println("우리는 \"개발자\" 입니다.");
		System.out.println("봄\\여름\\가을\\겨울");
		
		//실수 (float, double)========================================================
		
		float fVar1 = 3.14f;
		double dVar1 = 3.14;
		
		float fVar2 = 0.12345567891234f;
		double dVar2 = 0.12345567891234;
		
		System.out.println("fVar2 :" + fVar2);
		System.out.println("dVar2 :" + dVar2);
		
		float fVar3 = 3e-3f;
		double dVar3 = 3e6;
		
		System.out.println("fVar3 :" + fVar3);
		System.out.println("dVar3 :" + dVar3);
		
		//논리 타입 (Boolean)
		boolean stop = true;
		if(stop) {
			System.out.println("멈춥니다.");
		} else {
			System.out.println("달립니다.");
		}
	}
}

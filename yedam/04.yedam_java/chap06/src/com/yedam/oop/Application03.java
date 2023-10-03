package com.yedam.oop;

public class Application03 {
	public static void main(String[] args) {
		Computer computer = new Computer();
		
		//1) 배열을 활용
		int[] values1 = {1,2,3};
		int result1 = computer.sum1(values1); 
		System.out.println(result1);
		
		result1 = computer.sum1(new int[] {1,2,3,4}); //-> 바로 배열을 생성해서 매개변수로 넣어줄 수 있음
		System.out.println(result1);
		
		//2) 목록을 넘겨주는 방식
		int result2 = computer.sum2(1,2,3,4,5,6,7,8,9);
		System.out.println(result2);
		
		int result3 = computer.sum2(1,2,3,4);
		System.out.println(result3);
		
		//Calculator
		
		Calculator cal = new Calculator();
		cal.excute();
		
		double result5 = cal.areaRecctangle(20.4, 10.2);
		System.out.println(result5);
	}
}

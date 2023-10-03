package com.yedam.API;

public class BoxingExample {

	public static void main(String[] args) {
		//Boxing : 기본 타입 -> 객체로 포장
		Integer obj1 = new Integer(100); // 하이푼 => 사용할 수는 있지만, 권장하진 않는다는 뜻
		Integer obj2 = new Integer("100");

		Integer obj3 = Integer.valueOf("100");
		
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		
		System.out.println(value1);
		System.out.println(value2);
		
		//자동 박싱
		Integer obj5 = 100;
		System.out.println(obj5.intValue());
		
		//대입 시 자동 언박싱
		int value5 = obj5;
		System.out.println(value5);
		
		//연산 시 자동 언박싱
		int value6 = obj5 + 500;
		System.out.println(value6);
		
		//포장 값 비교
		Integer obj6 = 200;
		Integer obj7 = 200;
		
		System.out.println(obj6 == obj7); //false ( 박싱된 값이 범위를 벗어나게 되는 경우 비교하지 못한다. -> 그래서 언박싱한 다음 값을 비교해야 함 )
		System.out.println(obj6.intValue() == obj7.intValue()); //true
		
		double value7 = Double.parseDouble("3.14");
		System.out.println(value7); //3.14
	}
	
}


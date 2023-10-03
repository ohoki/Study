package com.yedam.oop;

import com.yedam.access.Access;

public class Application07 {

	//필드 선언
	int num = 1;
	
	//메소드 선언
	static void info() {
		System.out.println("info 출력");
	}
	
	public static void main(String[] args) {
		//자기 자신을 객체로 만든 예제 -> 절대 사용하지 말 것.
		Application07 app = new Application07();
		
		int a = app.num +  1;
		
		info();
		
		//클래스에 정의된 정적 멤버 사용
		//클래스명.필드명 | 클래스명.메소드명
		System.out.println(StaticCal.minus(10,5));
		System.out.println(StaticCal.plus(10,5));
		
		//final 상수
		Person p1 = new Person("111111-1111111", "김또치");
		
		System.out.println(p1.NATION);
		System.out.println(p1.SSN);
		System.out.println(p1.name);
		
//		p1.NATION = "미국";  <-- The final field Person.NATION cannot be assigned - 파이널 상수는 변경할 수 없다.
		
		System.out.println("지구의 반지름 : " + StaticCal.EARTH_RADIUS);
		System.out.println("지구의 표면적 : " + StaticCal.PI * StaticCal.EARTH_RADIUS * StaticCal.EARTH_RADIUS);
		
		//접근 제어자
		Access ac = new Access();
		ac.free = "public";
//		ac.parent = "protected"; -> 사용 불가
//		ac.basic = "default";    -> 사용 불가
//		ac.privacy = "private";  -> 사용 불가
		
	}
}

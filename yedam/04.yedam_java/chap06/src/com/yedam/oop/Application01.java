package com.yedam.oop;

public class Application01 {
	//실행 클래스
	public static void main(String[] args) {
		//Car claas -> 객체
		Car myCar = new  Car();
		
		System.out.println(myCar.company);
		System.out.println(myCar.price);
		System.out.println(myCar.name);
		//클래스 외부에서 인스턴스를 생성하고 필드를 호출하여 데이터 입력
		myCar.company = "현대";
		myCar.price = 1234;
		myCar.name = "소나타";
		
		System.out.println("======== 필드값 변경===========");
		System.out.println(myCar.company);
		System.out.println(myCar.price);
		System.out.println(myCar.name);
		
		Car yourCar = new Car();
		
		System.out.println("myCar 와 yourCar 데이터 비교");
		System.out.println(myCar.company);
		System.out.println(yourCar.company);
		
		System.out.println("===Korean Class를 활용한 객체 생성===");
		
		Korean k1 = new Korean("영호", "011111-1111111");
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		
		System.out.println("===생성자 오버로딩을 활용한 객체 생성===");
		
		Car oneCar = new Car("소나타");
		System.out.println("oneCar의 필드 name : "+ oneCar.name);
		
		oneCar.run();
		
		System.out.println(oneCar.info());
		
		Car threeCar = new Car("그랜져", 3000, "현대");
		System.out.println("threeCar의 필드 : "+ threeCar.name);
		System.out.println("threeCar의 필드 : "+ threeCar.price);
		System.out.println("threeCar의 필드 : "+ threeCar.company);
	}
}

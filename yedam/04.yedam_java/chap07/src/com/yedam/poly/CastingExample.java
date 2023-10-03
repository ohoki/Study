package com.yedam.poly;

public class CastingExample {
	public static void main(String[] args) {
		//강제 타입 변환
		//자동 타입 변환, 타입 변환시 사용했던 자식 클래스를 사용해야한다.
				
		Parent p1 = new Child(); // 자동 타입 변환
				
				
		p1.field = "부모필드";
		p1.method1();
		p1.method2();
				
		Child child = (Child)p1;
		child.method1();
		child.method2();
		child.field2 = "asdfasdf";
		child.method3();
		
		Parent p2 = new Parent();
		
		if(p2 instanceof Child02) {
			Child02 c2 = (Child02) p2;
		} else {
			System.out.println("Child02으로 자통 타입 변환 실패");
		}		
	}
}

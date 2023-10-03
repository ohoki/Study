package com.yedam.inter2;

public class Application {

	public static void main(String[] args) {
		//A(i) <- B <- C
		
		A a = new B();
		a.info();
		
		a = new C();
		a.info();
	}

}

package com.yedam.inter2;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		driver.drive(new Bus());
		driver.drive(new Taxi());
	}

}

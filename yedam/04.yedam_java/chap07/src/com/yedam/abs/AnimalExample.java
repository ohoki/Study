package com.yedam.abs;

public class AnimalExample {

	public static void main(String[] args) {
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		System.out.println("----------------------------");
		
		//추상클래스를 다형성으로 표현 - 추상클래스는 스스로를 객체로 만들지 못하기 때문
		//필드의 다형성
		
		Animal animal = dog;
		animal.sound();
		
		Animal animal2 = cat;
		animal2.sound();
		
		System.out.println("----------------------------");
		
		animalSound(new Dog());
		animalSound(new Cat());
	}

	//매개변수의 다형성을 활용 -> 추상 클래스
	public static void animalSound(Animal animal) {
		animal.sound();
	}
}

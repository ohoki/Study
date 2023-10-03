package com.yedam.oop;

public class Student {
	//학생의 정보를 관리하는 프로그램
			//학생의 정보를 관리하는 객체
			//이름 학년 국어 영어 수학
			String name;
			String grade;
			int kor;
			int eng;
			int math;
			
			//기본 생성자
			Student() { }
			
			//메소드 - 모든 정보를 출력하는 getInfo()
			void getInfo() {
				System.out.println("학생의 이름 : "+ name);
				System.out.println("학생의 학년 : "+ grade);
				System.out.println("국어 점수 : "+ kor);
				System.out.println("영어 점수 : "+ eng);
				System.out.println("수학 점수 : "+ math);
			}
}

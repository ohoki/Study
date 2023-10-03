package com.yedam.oop;

import java.util.Arrays;
import java.util.Scanner;

public class Application06 {

	public static void main(String[] args) {
		//1.학생수 | 2.정보 입력 | 3.정보 확인 | 4.분석 -> 전체 학생 점수의 총합(국+영+수 전체 합계), 총점의 평균, 개인별 가장 점수가 높은 과목 / 낮은 과목 | 5.종료 
		Scanner scanner = new Scanner(System.in);
		Student[] students = null;
		int sum = 0;
		//이름 학년 국어 영어 수학
		while(true) {
			System.out.println("======================================================");
			System.out.println("1.학생 수 입력 | 2.정보 입력 | 3.정보 확인 | 4.분석 | 5.종료");
			System.out.println("======================================================");
			
			System.out.println("항목의 번호를 입력해주세요>");
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo == 1) {
				
				System.out.println("학생 수를 입력해주세요>");
				int studentNo = Integer.parseInt(scanner.nextLine());
				students = new Student[studentNo];
				
			} else if(selectNo == 2) {
				
				for(int i=0; i<students.length; i++) {
					System.out.println((i+1)+"번째 학생의 정보\n");
					Student student = new Student();
					
					System.out.println("학생의 이름을 입력해주세요>");
					student.name = scanner.nextLine();
					
					System.out.println("학생의 학년을 입력해주세요>");
					student.grade = scanner.nextLine();
					
					System.out.println("학생의 국어 점수를 입력해주세요>");
					student.kor = Integer.parseInt(scanner.nextLine());
					
					System.out.println("학생의 영어 점수를 입력해주세요>");
					student.eng = Integer.parseInt(scanner.nextLine());
					
					System.out.println("학생의 수학 점수를 입력해주세요>");
					student.math = Integer.parseInt(scanner.nextLine());
					
					students[i] = student;
					//students[i] = new student(); -> 배열에 바로 객체를 만들어줘도 됨!!
				}
				
			} else if(selectNo == 3) {
				
				for(int i=0; i<students.length; i++) {
					System.out.println((i+1) + "번째 학생의 정보");
					students[i].getInfo();
					System.out.println();
				}
				
			} else if(selectNo == 4) {
				
				System.out.println("개인별 가장 높은 과목의 점수와 가장 낮은 과목의 점수");
				for(int i=0; i<students.length; i++) {
					int[] scores = {students[i].kor, students[i].eng, students[i].math}; 
					Arrays.sort(scores);
					
					System.out.println((i+1) + "번 학생의 가장 낮은 과목의 점수 : " + scores[0]);
					System.out.println((i+1) + "번 학생의 가장 높은 과목의 점수 : " + scores[2] + "\n");
				}
				
				System.out.println("\n전체학생의 국영수 점수 총합");
				for(int i=0; i<students.length; i++) {
					sum += (students[i].kor + students[i].eng + students[i].math);
				}
				System.out.println(sum + "\n");
				
				System.out.println("전체학생의 국영수 점수 총합의 평균");
				System.out.println((double)sum / students.length + "\n");
				
			} else if(selectNo == 5) {
				
				System.out.println("프로그램을 종료합니다.");
				break;
				
			} else {
				System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
			}
			
		}
		
		
		
	}

}

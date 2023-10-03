package com.yedam.array;

import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		int[] students = null;
		int studentCount = 0;
		
		while(run) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("선택>");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			if(selectNo == 1) {
				//학생수 입력
				System.out.println("선택>");
				studentCount = Integer.parseInt(sc.nextLine());
				System.out.println("학생수> studentCount");
			} else if(selectNo == 2) {
				//배열에 데이터 넣어주기
				students = new int[studentCount];
				
				for(int i=0; i<students.length; i++) {
					System.out.println("학생의 점수를 입력하세요>");
					int score = Integer.parseInt(sc.nextLine());
					students[i] = score;
				}
			} else if(selectNo == 3) {
				//배열 데이터 출력
				for(int i=0; i<students.length; i++) {
					System.out.println("score["+i+"]>"+students[i]);
				}
			} else if(selectNo == 4) {
				//최대값, 평균 구하기
				int maxScore = students[0];
				
				for(int i=0; i<students.length; i++) {
					if(maxScore < students[i]) {
						maxScore = students[i];
					}
				}
				
				int sum3 = 0;
				
				for(int i=0; i<students.length; i++) {
					sum3 += students[i];
				}
				double avg3 = (double)sum3/students.length;
				
				System.out.println("최고 점수: " + maxScore);
				System.out.println("평균 점수: " + avg3);
			} else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}

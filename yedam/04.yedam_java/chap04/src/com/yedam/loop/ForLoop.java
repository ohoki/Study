package com.yedam.loop;

import java.util.Scanner;

public class ForLoop {

	public static void main(String[] args) {
		//for문================================================================================
		int result = 0;
		
		for(int i =0; i<=100; i++) {
			result += i;
		}
		System.out.println(result);
		//입력한 숫자에 대한 구구단 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("구구단 입력>");
		
		int gugu = Integer.parseInt(sc.nextLine());
		for(int i=1; i<=9; i++) {
			System.out.println( gugu+"*"+i+"= "+(gugu*i) );
		}
		
		//ex1)
		System.out.println("몇번 반복하시겠습니까>");
		int count = Integer.parseInt( sc.nextLine() );
		
		int[] numbers = new int[count];
		for(int i=0; i<count; i++) {
			System.out.println("숫자를 입력해주세요.>");
			numbers[i] = Integer.parseInt( sc.nextLine() ); 
		}
		
		int sum = 0;
		double avg;
		int max = numbers[0];
		int min = numbers[0];
	
		for(int i =0; i<numbers.length; i++) {
			sum += numbers[i];
			
			if(numbers[i] > max) {
				max = numbers[i];
			}
			
			if(numbers[i] < min) {
				min = numbers[i];
			}
		}
		avg = (double)sum/count;
		
		System.out.println("총합은"+ sum + ", 평균은"+ avg + ", 최대값은"+ max + ", 최소값은"+ min );
		
		//임의의 랜덤 값(1~100) 하나 추출
		int randomNumber = (int)(Math.random()*100)+1;
		
		for(int i=1; i<=5; i++) {
			System.out.println("숫자를 입력해주세요>");
			int data = Integer.parseInt(sc.nextLine());
			
			if (data == randomNumber) {
				System.out.println("정답 입니다! " + i + "번 만에 맞추셨습니다!");
				break;
			} else {
				if (i == 5) {
					System.out.println("모든 기회를 소진하셨습니다.");
					break;
				} else {
					if (data > randomNumber) {
						System.out.println("더 낮은 숫자를 입력하세요.");
					} else {
						System.out.println("더 높은 숫자를 입력하세요.");
					}
				}
			}
			
		}
	}

}

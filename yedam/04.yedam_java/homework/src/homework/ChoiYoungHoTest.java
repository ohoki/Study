package homework;

import java.util.Arrays;
import java.util.Scanner;

public class ChoiYoungHoTest {

	public static void main(String[] args) {
	//문제1
		int num1 = 10;
		double num2 = 2.0;
		
		System.out.println("덧셈 : " + ( num1 + (int)num2 ));
		System.out.println("뺄셈 : " + ( num1 - (int)num2 ));
		System.out.println("곱샘 : " + ( num1 * (int)num2 ));
		System.out.println("나눗샘 : " + ( num1 / (int)num2 ));	
	
	//문제2
		// (1) false (2) true (3) false
		
		System.out.println("\n"); // 출력값 정리용
	//문제3
		//큰 금액부터 동전을 우선적으로 거슬러 줘야한다.
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		System.out.println("money=" + money);
		for(int i=0; i<coinUnit.length; i++) {
			int coinNum = money/coinUnit[i];
			
			money %= coinUnit[i];
			
			//출력값 정리하기 위해서 if문 사용
			if( coinUnit[i] == 10 ) {
				System.out.print( coinUnit[i] + "원 : " + coinNum + "개 ");
			} else {
				System.out.print( coinUnit[i] + "원 : " + coinNum + "개, ");
			}
		}
		
		System.out.println("\n"); // 출력값 정리용
	//문제4
		for(int i=2; i<=9; i++) {
			System.out.println("\n구구단 " + i + "단 출력");
			for(int j=1; j<=i; j++) {
				System.out.println( i + " * " + j + " = " + i*j );
			}	
		}
		
		System.out.println("\n"); // 출력값 정리용
	//문제5
		Scanner sc = new Scanner(System.in);
		int[] diceValues = new int[30];
		int diceSize = 0;
		
		while(true) {
			System.out.println("=== 1.주사위 크기 | 2.주사위 굴리기 | 3.결과 보기 | 4.가장 많이 나온 수 | 5.종료 ===");
			
			System.out.println("항목의 번호를 입력해주세요>");
			int selectNo = Integer.parseInt(sc.nextLine());
			
			if(selectNo == 1) {
				System.out.println("주사위 크기 >");
				int value = Integer.parseInt(sc.nextLine());
				
				if( (5 <= value) && (value <= 10) ) {
					diceSize = value;
				} else {
					System.out.println("범위를 벗어났습니다. 5~10사이의 수를 입력해주세요.");
				}
			} else if(selectNo == 2) {
				int diceCount = 0;
				
				for(int i=0; i<diceValues.length; i++) {
					int diceValue = (int)(Math.random()*diceSize)+1;
					
					diceValues[i] = diceValue;
					if(diceValue == 5) { 
						diceCount = i+1;
						break; 
					}
				}
				
				System.out.println("5가 나올 때까지 주사위를 "+ diceCount + "번 굴렸습니다.");
			} else if(selectNo == 3) {
				for(int j=1; j<=diceSize; j++) {
					int count = 0;
					
					for(int i=0; i<diceValues.length; i++) {
						if(diceValues[i] == 0) { break; }
						if(j == diceValues[i]) { count++; }	
					}
					
					System.out.println(j + "은 " + count + "번 나왔습니다.");
				}
			} else if(selectNo == 4) {
				int[] mode = new int[diceSize];
				
				for(int i=0; i<mode.length; i++) {
					if(diceValues[i] == 0) {
						continue;
					}
					mode[diceValues[i]-1]++;
				}
				
				int max = mode[0];
				int maxIdx = 0;
				
				for(int i=0; i<mode.length; i++) {
					if(max < mode[i]) {
						maxIdx = i+1;
					}
				}
				
				System.out.println("가장 많이 나온 수는 " + maxIdx + "입니다.");
			} else if(selectNo == 5) {
				
				System.out.println("프로그램 종료");
				break;
				
			} else {
				System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
			}
			
		}
	}  

}

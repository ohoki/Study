package homework;

import java.util.Arrays;
import java.util.Scanner;

public class ChoiYoungHoTest2 {

	public static void main(String[] args) {
	//문제5
		Scanner sc = new Scanner(System.in);
		int[] diceCount = null;
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
				diceCount = new int[diceSize];
				int diceValue = 0;
				int count = 0;
				
				while(diceValue != 5) {
					diceValue = (int)(Math.random()*diceSize)+1;
					
					diceCount[diceValue-1]++;
					count++;
				}
				
				System.out.println("5가 나올 때까지 주사위를 "+ count + "번 굴렸습니다.");
			} else if(selectNo == 3) {
				for(int i=0; i<diceCount.length; i++) {
					System.out.println( (i+1) + "은 " + diceCount[i] + "번 나왔습니다.");
					}
			} else if(selectNo == 4) {
				int max = 0;
				int maxIdx = 0;
				
				for(int i=0; i<diceCount.length; i++) {
					if(max < diceCount[i]) {
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

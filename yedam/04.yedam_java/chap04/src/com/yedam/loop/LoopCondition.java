package com.yedam.loop;

public class LoopCondition {

	public static void main(String[] args) {
		//While break;
		while(true) {
			int num = (int)(Math.random()*6)+1;
			System.out.println(num);
			if( num == 6 ) {
				break;
			}
		}
		
		//중첩 for문 break;
		for(int i =0; i<= 10; i++) {
			for(int j=0; j<=10; j++) {
				if(j==5) {
					System.out.println("i + j = " + (i + j));
					break;
				} else {
					System.out.println(j);
				}
			}
		}
		
		//for문 label break;
		Outter : for(char upper = 'A'; upper <= 'Z'; upper++) {
			for (char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + " - " + lower);
				if (lower == 'g') {
					break Outter;
				}
			}
		}
		
		//continue
		for(int i=0; i<=10; i++) {
			if (i%2 == 0) {
				continue;
			}
			System.out.println(i);
		}
	}

}

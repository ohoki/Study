package com.yedam.loop;

public class ForLoop2 {

	public static void main(String[] args) {
		//중첩 for문
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println( i + "*" + j + "=" + (i*j) );
			}
		}
		
		for(int i=0; i<=5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

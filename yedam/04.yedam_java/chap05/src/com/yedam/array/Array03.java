package com.yedam.array;

import java.util.*;

public class Array03 {

	public static void main(String[] args) {
		//다차원 배열===========================================================================
		int[][] intAry = { {1,2}, {1,2,3} };
		
		int[][] mathScore = new int[2][3];
		
		for(int i=0; i<mathScore.length; i++) {
			for(int j=0; j<mathScore[i].length; j++) {
				System.out.println(mathScore[i][j] );
			}
		}
		
		//구구단 넣기
		int[][] gugu = new int[8][9];
		
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				gugu[i-2][j-1] = i*j;
			}
		}
		
		for(int i=0; i<gugu.length; i++) {
			System.out.println((i+2)+ "단");
			System.out.print(Arrays.toString(gugu[i]));
			System.out.println();
		}
		
		//참조 타입 배열 ==========================================================================
		String[] strAry = new String[3];
		strAry[0] = "yedam";
		strAry[1] = "yedam";
		strAry[2] = new String("yedam");
		
		//String 배열간의 주소값 비교
		System.out.println(strAry[0] == strAry[1]);
		System.out.println(strAry[0] == strAry[2]);
		//String 배열간의 데이터 비교
		System.out.println(strAry[0].equals(strAry[2]));
		
		//배열 복사 (for 문 이용) =====================================================================
		int[] oldAry = {1,2,3};
		int[] newAry = new int[5];
		
		for(int i=0; i<oldAry.length; i++) {
			newAry[i] = oldAry[i];
		}
		
		for(int i=0; i<newAry.length; i++) {
			System.out.println(newAry[i]);
		}
		
		//배열 복사 (arrayCopy)
		int[] oldAry2 = {1,2,3,4,5,6,7};
		int[] newAry2 = new int[10];
		
		System.arraycopy(oldAry2, 1, newAry2, 3, oldAry2.length-1);
		for(int i=0; i<newAry2.length; i++) {
			System.out.println(newAry2[i]);
		}
		
		//향상된 for문 =================================================================================
		for(int temp : newAry2) {
			System.out.print(temp + "\t");
		}
		
		
		
	}
}

package com.yedam.array;

public class Array01 {

	public static void main(String[] args) {
		//배열 생성 1
		int[] intAry = {1,2,3,4,5,6};
		
		//배열 생성 2
		int[] intAry2 = new int[6];
		
		System.out.println("intAry의 첫번째 값 : " + intAry2[0] ); //default 값 0
		
		//배열에 데이터 넣기
		for(int i=0; i<6; i++) {
			intAry2[i] = i+1;
		}
		
		//배열 생성 3
		int[] intAry3;
		intAry3 = new int[] {1,2,3,4,5,6};
		
		//String 배열
		String[] arr2 = new String[3];
		arr2[0] = "3월";
		arr2[1] = "4월";
		arr2[2] = "5월";
		
		for(int i=0; i<3; i++) {
			System.out.println("arr["+i+"] : " + arr2[i]);
		}

	}

}

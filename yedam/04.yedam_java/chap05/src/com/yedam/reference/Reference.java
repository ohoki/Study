package com.yedam.reference;

import java.util.Arrays;

public class Reference {

	public static void main(String[] args) {
		//참조 : 배열
			int[] array = {1,2,3,4,5,6};
			int[] array2 = {1,2,3,4,5,6};
			int[] array3 = null;
			
			System.out.println(array2);
			System.out.println(Arrays.equals(array, array2));
			System.out.println(array3 == null);

	}

}

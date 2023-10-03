package homework;

import java.util.*;

public class ChoiYoungHo_homework_230510 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr1 = {10,20,30,50,3,60,-3};
		
		//문제1
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] == 60) {
				System.out.println("arr1배열에서 60인 곳의 인덱스 값은 : "+i);
			}
		}
		
		//문제2
		for(int i=0; i<arr1.length; i++) {
			if(i == 3) { continue; }
			System.out.print(arr1[i]+" ");
		}
		
		//문제3
		System.out.println("변경하고 싶은 인덱스의 번호를 입력해주세요>");
		int updateIdx = Integer.parseInt(scanner.nextLine());
		
		arr1[updateIdx] = 1000;
		System.out.println(updateIdx+"번 인덱스의 값이 1000으로 변경되었습니다.");

		//문제4
		int[] arr2 = new int[10];
			//배열에 데이터 저장
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = (int)(Math.random()*100)+1;
		}
		System.out.println("====랜덤으로 받은 배열====");
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("====랜덤으로 받은 배열에서 3의 배수 출력====");
		for(int i=0; i<arr2.length; i++) {
			if(arr2[i]%3 == 0) {
				System.out.print(arr2[i]+" ");
			}
		}
		System.out.println();
		//문제5
		int[] project = new int[28];
		
		//배열에 랜덤값 넣어주기 (중복x)
		for(int i=0; i<project.length; i++) {
			project[i] = (int)(Math.random()*30)+1;
			for(int j=0; j<i; j++) {
				if(project[i] == project[j]) {
					project[i] = 0;
					i--;
					break;
				}
			}
		}
		Arrays.sort(project);
		System.out.println("========과제를 제출한 출석번호===========");
		System.out.println(Arrays.toString(project));
		
		//제출하지 않은 학생의 출석번호 출력
		System.out.println("========제출하지 않은 학생의 출석번호===========");
		
		for(int j=1; j<=30; j++) {
			boolean submit = false;
			for(int i=0; i<project.length; i++) {
				if(j == project[i]) {
					submit = true;
					break;
				}
			}
			if(!submit) {
			System.out.print(j+"번 " );
			}
		}

	}
}

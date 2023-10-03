package homework;

import java.util.*;

public class youngho_homework2_230509 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//문제1
		System.out.println("x값을 입력해주세요>");
		int x = Integer.parseInt(scanner.nextLine());
		System.out.println("y값을 입력해주세요>");
		int y = Integer.parseInt(scanner.nextLine());
		
		if(x != 0 && y != 0) {
			if(x > 0) {
				if (y > 0) {
					System.out.println("제1사분면 입니다.");
				} else {
					System.out.println("제4사분면 입니다.");
				}
			} else if(x < 0) {
				if (y > 0) {
					System.out.println("제2사분면 입니다.");
				} else {
					System.out.println("제3사분면 입니다.");
				}
			}
		} else {
			System.out.println("(0,0) 입니다.");
		}
		
		//문제2
		System.out.println("년도를 입력해주세요>");
		int year = Integer.parseInt(scanner.nextLine());
		
		if( (year%4==0 && year%100 !=0) || year%400==0 ) {
			System.out.println("윤년입니다.");
		} else {
			System.out.println("윤년이 아닙니다.");
		}
		
		//문제3
		System.out.println("가위,바위,보 중 하나를 입력해주세요.");
		String data = scanner.nextLine();
		
		switch(data) {
		case "가위":
			System.out.println("이기기 위해선 바위를 내야합니다.");
			break;
		case "바위":
			System.out.println("이기기 위해선 보를 내야합니다.");
			break;
		case "보":
			System.out.println("이기기 위해선 가위를 내야합니다.");
			break;
		}
		
		//문제4
		for(int i=1; i<=5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//문제5
		System.out.println("m값을 입력해주세요>");
		int m = Integer.parseInt(scanner.nextLine());
		System.out.println("n값을 입력해주세요>");
		int n = Integer.parseInt(scanner.nextLine());
		
		for(int i=1; i<=n; i++) {
			System.out.println(m + "*" + i + "=" + m*i);
		}
	}
}

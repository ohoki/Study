package homework;

import java.util.Scanner;

public class Question03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Culture movie = new Movie("추격자", 7, 5, "스릴러");
		
		System.out.println("관객 수를 입력해주세요>");
		int movieAttendNum = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<movieAttendNum; i++) {
			System.out.println("점수를 입력해 주세요>");
			int score = Integer.parseInt(sc.nextLine());
			
			movie.setTotalScore(score);
		}
		
		movie.getInformation();
		
		System.out.println("========================================");
		
		Culture performance = new Performance("지킬앤하이드", 9, 10, "스릴러");
		
		System.out.println("관객 수를 입력해주세요>");
		int perAttendNum = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<perAttendNum; i++) {
			System.out.println("점수를 입력해 주세요>");
			int score = Integer.parseInt(sc.nextLine());
			
			performance.setTotalScore(score);
		}
		
		performance.getInformation();

	}

}
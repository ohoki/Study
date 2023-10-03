package homework;

import java.util.*;

public class StringGame {
	//필드
	private String answer;
	
	//스캐너 생성
	Scanner sc = new Scanner(System.in);
	
	//생성자
	public StringGame() {
		this.randomAnswer();
	}
	
	private void randomAnswer() {
		int selectAnswer = (int)(Math.random()*4)+1;
		
		if(selectAnswer == 1) {
			this.answer = "orange";
		} else if(selectAnswer == 2) {
			this.answer = "game";
		} else if(selectAnswer == 3) {
			this.answer = "phone";
		} else if(selectAnswer == 4) {
			this.answer = "smart";
		}
	}
	
	private List<Character> charData = new ArrayList<>();
	//메소드
	public void setCharData() {
		
		showCharData();
		
		if(charData.size() == answer.length()) {
			System.out.println("문자열을 구성하는 문자를 다 입력했습니다.");
		} else {
			System.out.println("입력 값>>");
			char data = Character.toLowerCase( sc.nextLine().charAt(0) );
			
//			boolean isContain = false;
//			
//			for(int i=0; i<answer.length(); i++) {
//				
//				if( data == answer.charAt(i) ) {
//					System.out.println("문자열을 구성하는 문자입니다.");
//					charData.add(data);
//					isContain = true;
//				}	
//			}
//			
//			if(isContain == false) {
//				System.out.println("문자열을 구성하는 문자가 아닙니다.");	
//			}
			
// ======== for 문 대신 ===============================================
			if(answer.indexOf(data) != -1) {
				System.out.println("문자열을 구성하는 문자입니다.");
				charData.add(data);
			} else {
				System.out.println("문자열을 구성하는 문자가 아닙니다.");	
			}
		}
	}
	
	public void setStrData() {
		
		showCharData();
		
		System.out.println("\n입력 값>>");
		String data = sc.nextLine().toLowerCase();
		
		if( data.equals(answer) ) {
			System.out.println("정답입니다.");
		} else {
			for(int i=0; i<answer.length(); i++) {
				if(data.length() == answer.length()) {
					if( data.charAt(i) == answer.charAt(i) ) {
						System.out.print("O ");
					} else {
						System.out.print("X ");
					}
				} else {
					System.out.println("입력된 문자열의 길이가 정답과 다릅니다.");
					break;
				}
			}
		}
		System.out.println();
	}
	
	public void showCharData() {
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		for(char data : charData) {
			System.out.print(data + "  ");
		}
		System.out.println();
	}
	
	public void init() {
		System.out.println("새로운 게임을 시작합니다.");
		
		charData.clear();
		this.randomAnswer();
	}
}

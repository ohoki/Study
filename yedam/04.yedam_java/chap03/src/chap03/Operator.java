package chap03;

public class Operator {

	public static void main(String[] args) {
		//++num, num++ =========================================================================
		int num = 0;
		
		System.out.println(num++);
		System.out.println(++num);
		System.out.println(num--);
		System.out.println(--num);
		
		//논리 부정 연산자 ! =======================================================================
		boolean play = true;
		
		play = !play;
		System.out.println(play);
		
		//비교 연산자 =============================================================================
		int num1 = 10, num2 = 10;
		boolean result1 = (num1 == num2);
		boolean result2 = (num1 != num2);
		boolean result3 = (num1 <= num2);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
		char char1 = 'A'; //65
		char char2 = 'B'; //66
		boolean result4 = (char1 < char2);
		System.out.println(result4);
		
		//논리 연산자 ==============================================================================
		char charCode = 'A';
		//A보다 크거나 같고 Z보다 작거나 같은 경우
		if(charCode >= 65 && charCode <= 90) {
			System.out.println("대문자 입니다.");
		}
		//논리 부정 연산자
		if(!(charCode<65) && !(charCode>90)) {
			System.out.println("대문자 입니다");
		}
		//a보다 크거나 같고 z보다 작거나 같은 경우
		if(charCode >= 97 && charCode <=122) {
			System.out.println("소문자 입니다.");
		}
	}

}


public class FirstMethod {
	                                 //parameter (매개변수)
	public static void primtTwoTimes(String text, String delimiter) {
		System.out.println(delimiter);
		System.out.println(text);
		System.out.println(text);
	}

	public static void main(String[] args) {
		
		//수 많은 코드 속에서 연관되어 있는 코드들을 그룹화해서 정리해놓은 것 - Method
		//Method를 활용해서 코드를 단순화 하고 보다 더 이해하기 쉽게 만드는 습관은 아주 좋다
		
		//1억 줄
		System.out.println("-");
		System.out.println("A");
		System.out.println("A");
		//1억 줄
		System.out.println("-");
		System.out.println("A");
		System.out.println("A");
		//1억 줄
		             //argument (인자)
		primtTwoTimes("a", "***");
	}

	//함수 선언 시 들어있는 엘리먼트는 parameter라고 부르고, 함수에 실제로 주입되는 엘리먼트는 argument라고 부른다.
}

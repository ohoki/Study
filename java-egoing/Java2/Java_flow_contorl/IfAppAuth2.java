
public class IfAppAuth2 {

	public static void main(String[] args) {
		
		String id = "youngho";
		String inputId = args[0];
		
		String pass = "1111";
		String pass2 = "2222";
		String inputPass = args[1];
		
		System.out.println("Hi.");
		boolean isRightPass = (inputPass.equals(pass) || inputPass.equals(pass2));
//		if (id == inputId)   false 값 출력 ( == 은 객체의 주소값을 비교하는 연산자 / equals는 두 객체의 데이터값을 비교함)
		if (inputId.equals(id) && isRightPass ) {
			System.out.println("Master");
		} else {
			System.out.println("Who are you?");
		};
	};
};

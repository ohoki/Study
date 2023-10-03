
public class Casting {

	public static void main(String[] args) {
		
		double a = 1.1;
		double b = 1; //double b = (double) 1;
		//손실이 없기에 자동으로 캐스팅 됨
		
		System.out.println(b); // 1이 아니라 1.0이 반환된다. double 이니까!
		
		//int c = 1.1; //잃어버리는 값이 생기므로 불가능
		double d = 1.1;
		int e = (int) 1.1;
		//손실이 생기기 때문에 반드시 명시적으로 형변환을 해줘야한다
		
		System.out.println(e); //1.1이 아닌 1이 반환!
		
		// 1 to String
		String f = Integer.toString(1);
		System.out.println(f); //문자열 1이 반환됨!!
		
		//자바의 경우 변수의 데이터 타입을 철저하게 통제하고 있어서 코드 작성시 변수의 데이터 타입을 변환해야 하는 경우, 변수를 변환하는 과정을 캐스팅이라고 한다!!
	}

}

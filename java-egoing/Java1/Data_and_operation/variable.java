
public class variable {

	public static void main(String[] args) {
		
		//자바의 경우 변수 이름 앞에 변수의 데이터 타입을 지정해줘야 함!!
	    //이렇게 변수를 선언하면, 메모리의 빈 공간에 "변수 타입"에 알맞은 크기의 저장공간이 확보되고, 변수 이름을 붙혀서 이 이름을 통해 해당 저장공간을 사용할 수 있게 된다.
		int a= 1; // Number -> integer(정수)
		System.out.println(a); //1
		
		double b = 1.1; //real number -> double ... -2.0, -1.0, 0, 1.0, 2.0 ...
		System.out.println(b); //1.1
		
		String c = "Hello World";
		System.out.println(c); //Hello World
	}
}

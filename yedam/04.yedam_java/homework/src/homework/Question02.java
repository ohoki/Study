package homework;

public class Question02 {

	public static void main(String[] args) {
		Human h1 = new StandardWeightInfo("홍길동", 168, 45);
		Human h2 = new ObesityInfo("박둘이", 168, 90);
		h1.getInformation();
		h2.getInformation();
	}

}

package homework;

public class youngho_homework_230508 {

	public static void main(String[] args) {
		//문제1
		int num1 = 37, num2 = 91;
		System.out.println("num1: "+num1+", num2: "+num2);
		
		//문제2
		System.out.println(num2 + num1);
		System.out.println(num2 - num1);
		System.out.println(num2 * num1);
		System.out.println(num2 / num1);
		
		//문제3
		int var1 = 128;
		System.out.printf(var1+", int\n");	

		String var2 = "B";
		System.out.printf(var2+", String\n");

		char var3 = 44032;
		System.out.printf(var3+", char\n");

		long var4 = 100000000000L;
		System.out.printf(var4+", long\n");

		double var5 = 43.93106;
		System.out.printf(var5+", double\n");

		float var6 = 301.3f;
		System.out.printf(var6+", float\n");

		//문제4
		byte a = 35, b = 25;
		int c = 463;
		long d = 1000L;
		double e = 45.31;
		
		long result1 = a + c + d;
		System.out.println(result1);

		int result2 = a + b + c;
		System.out.println(result2);

		double result3 = c + d + e;
		System.out.println(result3);

		//문제5

		int intValue1 = 24, intValue2 = 3,
		    intValue3 = 8,  intValue4 = 10;
		char charValue = 'A';
		String strValue = "번지";

		System.out.printf("%c%d%d%s%d.0", charValue, intValue1+intValue2, intValue3, strValue, intValue4);
	}

}

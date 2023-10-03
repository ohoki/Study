package homework;

public class youngho_homework1_230509 {

	public static void main(String[] args) {
		//문제1
		int x = -5, y = 10;
		int result;
		
		result = -x;
		System.out.printf("x : %d, result : %d\n", x, result);
		
		result = ++x +  y--;
		System.out.printf("x : %d, y : %d, result : %d\n", x, y, result);
		
		result = --x + ++y;
		System.out.printf("x : %d, y : %d, result : %d\n", x, y, result);
		
		//문제2
		int m = 10, n = 5;
		
		System.out.println( !(( m*2 == n*4 )||( n<=5 )) );		
	    System.out.println( !(( m/2 > 5)&&( n%2 < 1)) );
	    
	    //문제3
	    int val = 0;
	    
	    val = (val+10-5)*3/5;
	    
	    //문제4
	    int intResult = val > 0 ? val : 0;
	    System.out.println(intResult);
	    
	    //문제5
	    int a = 10, b = -8;
	    String strResult;
	    
	    if (a > 0 && b > 0) {
	    	strResult = "both a and b are zero or more";
	    	System.out.println(strResult);
	    } else {
	    	strResult = "One of a or b is negative number";
	    	System.out.println(strResult);
	    }
	}
}

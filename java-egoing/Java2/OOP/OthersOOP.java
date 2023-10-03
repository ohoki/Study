import java.io.FileWriter;
import java.io.IOException;

public class OthersOOP {

	public static void main(String[] args) throws IOException {

		System.out.println(Math.PI); //Math라는 클래스 안에 PI라는 변수
		System.out.println(Math.floor(1.4)); //Math라는 클래스 안에 floor라는 메서드
		
		FileWriter f1 = new FileWriter("data.txt");
		f1.write("Hello");
		f1.write(" Java");
		f1.close();
		
		
	}

}

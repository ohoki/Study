import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class InstanceApp {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter p1 = new PrintWriter("result1.txt");
		p1.write("Hello 1");
		p1.close();

		PrintWriter p2 = new PrintWriter("result2.txt");
		p2.write("Hello 2");
		p2.close();
			
		//클래스를 사용할 때 클래스를 만든 사람이 그 클래스를 인스턴스로 활용하기를 원한다면 constructor(생성자)라는 것을 가지고 있고 new 뒤로 붙은 것(PrintWriter("result1.txt");)이 constructor이다. 
		//이 과정을 통해 복제된 것(p1)이 인스턴스이며 그 인스턴스에 어떤 값이 올 수 있는지 규제하기 위해 p1 앞에 PrintWriter라는 클래스를 적는다.
		//Math 클래스처럼 일회용 클래스가 아닌 경우, 여러개의 파일을 작업해야할 수도 있기 때문에 각각의 다른 상태를 가지고 있는 인스턴스를 만들어 사용하는 것이 효율적이다.
		
		//기존의 클래스를 상속받아 확장(extends)시켜 새로운 클래스(자식 클래스)를 만들 수 있다. 자식 클래스는 부모 클래스의 메서드 및 변수를 상속 받고, 새로운 기능을 추가하거나 덮어쓰기(override)할 수 있다.
	}

}

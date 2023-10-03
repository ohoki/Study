package homework;

public class Employee {
	public String name;
	public int sal;
	
	Employee(String name, int sal) {
		this.name = name;
		this.sal =sal;
	}

	public String getName() {
		return name;
	}

	public int getSal() {
		return sal;
	}
	
	public void getInformation() {
		System.out.println("이름 : " + name + " 연봉 : " + sal);
	}
	
	public void print() {
		System.out.println("수퍼클래스");
	}
}

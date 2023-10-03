package homework;

public class Human {
	public String name;
	public int cm;
	public int kg;
	
	Human(String name, int cm, int kg) {
		this.name = name;
		this.cm = cm;
		this.kg = kg;
	}
	
	public void getInformation() {
		System.out.println("이름 : " + name + " 키 : " + cm + " 몸무게 : " + kg );
	}
}

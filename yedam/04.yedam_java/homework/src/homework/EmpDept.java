package homework;

public class EmpDept extends Employee{
	public String dept;
	
	EmpDept(String name, int sal, String dept) {
		super(name,sal);
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}

	@Override
	public void getInformation() {
		System.out.println("이름 : " + super.name + " 연봉 : " + super.sal + " 부서 : " + dept);
	}

	@Override
	public void print() {
		super.print();
		System.out.println("서브클래스");
	}
}

class Foo{
	public static String classVar = "I class var";
	public String instanceVar = "I instance var";
	public static void classMethod() {
		System.out.println(classVar); //OK (static이 붙은 클래스 소속 변수는 호출 가능)
//		System.out.println(instanceVar); //Error (static이 붙지않은 인스턴스 소속 변수는 호출 불가!)
	}
	public void instanceMethod() {
		System.out.println(classVar); //OK (static이 붙은 클래스 소속 변수는 인스턴스 메소드에서 호출 가능)
		System.out.println(instanceVar); //OK (static이 붙지않은 인스턴스 소속 변수 호출 가능)
	}
}

public class StaticApp {
	public static void main(String[] args) {
		System.out.println(Foo.classVar); //OK (static이 붙은 클래스 소속 변수는 호출 가능)
//		System.out.println(Foo.instanceVar); //Error (static이 붙지않은 인스턴스 소속 변수는 호출 불가!)
		
		Foo.classMethod(); //OK
//		Foo.instanceMethod(); //Error
		
		Foo f1 = new Foo();
		Foo f2 = new Foo();
		
		System.out.println(f1.classVar); // I class var
		System.out.println(f1.instanceVar); //I instance var
		
		f1.classVar = "changed by f1";
		System.out.println(Foo.classVar); //changed by f1
		System.out.println(f2.classVar); //changed by f1
		
		f1.instanceVar = "changed by f1";
		System.out.println(f1.instanceVar); //changed by f1
		System.out.println(f2.instanceVar); //I instance var
		
	}

}

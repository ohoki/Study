
public class OutputMethod {

	public static void main(String[] args) {
	
		//return은 메소드의 종료를 알리며, 결과값을 반환하는 명령어
		//method는 결과값이 어떤 데이터타입인지 적어줘야한다
		//void는 return값이 없다 는 표시
		
		tWoTimes("a", "------");
	}
	
	public static String tWoTimes(String text, String delimeter) {
		String out = "";
		out = out + delimeter + "\n";
		out = out + text + "\n";
		out = out + text + "\n";
		return out;
	}
}

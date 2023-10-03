
public class LoopArray {

	public static void main(String[] args) {
		
		String[] users = new String[3];
		users[0] = "youngho";
		users[1] = "dongho";
		users[2] = "jinhak";
		
		for(int i=0; i<users.length; i++) {
			System.out.println("<li>"+users[i]+"</li>");
		}
	}
}

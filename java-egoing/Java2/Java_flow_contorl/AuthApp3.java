
public class AuthApp3 {

	public static void main(String[] args) {
		
//		String[] users = {"youngho", "dongho", "jinhak"};
		String[][] users = {
				{"youngho", "1111"},
				{"dongho", "2222"},
				{"jinhak", "3333"}
		};
		
		String inputId = args[0];
		String inputPass = args[1];
		boolean isLogined = false;
		
		for(int i=0; i<users.length; i++) {
			String[] currentId = users[i];
			if(currentId[0].equals(inputId) && currentId[1].equals(inputPass) ) {
				isLogined = true;
				break;
			}
		}
		System.out.println("Hi.");
		if(isLogined) {
			System.out.println("Master!!");
			} else {
			System.out.println("Get out!!");
			}
	}
}
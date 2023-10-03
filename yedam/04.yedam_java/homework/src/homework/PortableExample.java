package homework;

public class PortableExample {

	public static void main(String[] args) {
		PortableNotebook pn = new PortableNotebook("한글2020", "크롬", "영화", "안드로이드앱");
		
		pn.writeDocumentation();
		pn.watchVideo();
		pn.changeMode();
		pn.useApp();
		pn.searchInternet();
	}
}
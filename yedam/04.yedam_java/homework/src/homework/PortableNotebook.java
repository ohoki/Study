package homework;

public class PortableNotebook implements Notebook, Tablet {
	int MODE;
	String program;
	String browser;
	String kindVideo;
	String kindApp;
	
	
	
	public PortableNotebook(String program, String browser, String kindVideo, String kindApp) {
		this.program = program;
		this.browser = browser;
		this.kindVideo = kindVideo;
		this.kindApp = kindApp;
		this.MODE = NOTEBOOK_MODE;
		System.out.println("NOTEBOOK_MODE");
	}

	@Override
	public void watchVideo() {
		System.out.println("'영상종류'를 시청");
	}

	@Override
	public void useApp() {
		if(MODE == NOTEBOOK_MODE) {
			MODE = TABLET_MODE;
			System.out.println("'앱종류'를 실행.");
		} else if(MODE == TABLET_MODE) {
			System.out.println("'앱종류'를 실행.");
		}
	}

	@Override
	public void writeDocumentation() {
		System.out.println("'문서 프로그램'을 통해 문서를 작성");
	}

	@Override
	public void searchInternet() {
		System.out.println("'인터넷 브라우저'를 통해 인터넷을 검색");
	}
	
	public void changeMode() {
		if(MODE == NOTEBOOK_MODE) {
			MODE = TABLET_MODE;
			System.out.println("현재 모드 : TABLET_MODE");
		} else if (MODE == TABLET_MODE) {
			MODE = NOTEBOOK_MODE;
			System.out.println("현재 모드 : NOTEBOOK_MODE");
		}
	}

}

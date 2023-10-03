package homework;

public class Performance extends Culture{
	String genre;
	
	Performance(String title, int director, int actor, String genre) {
		super(title, director, actor);
		this.genre = genre;
	}
	
	public void getInformation() {
		System.out.println("공연제목 : " + title);
		System.out.println("감독 : " + director);
		System.out.println("배우 : " + actor);
		System.out.println("관객 수 : " + attend);
		System.out.println("공연총점 : " + totalScore);
		System.out.println("공연평점 : " + getGrade());
	}
}

package homework;

public class Movie extends Culture{
	String genre;
	
	Movie(String title, int director, int actor, String genre) {
		super(title, director, actor);
		this.genre = genre;
	}

	@Override
	public void getInformation() {
		System.out.println("영화제목 : " + title);
		System.out.println("감독 : " + director);
		System.out.println("배우 : " + actor);
		System.out.println("관객 수 : " + attend);
		System.out.println("영화총점 : " + totalScore);
		System.out.println("영화평점 : " + getGrade());
	}
}

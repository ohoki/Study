package homework;

public abstract class Culture {
	String title;
	int director;
	int actor;
	int attend =0;
	int totalScore = 0;
	
	Culture(String title, int director, int actor) {
		this.title = title;
		this.director = director;
		this.actor = actor;
	}

	public void setTotalScore(int score) {
		//점수는 5점까지만 줄 수 있다.
		if(score > 5) {
			System.out.println( "점수는 5점까지만 줄 수 있습니다.");
		} else {
			this.totalScore += score;
			this.attend++;
		}
	}
	
	public String getGrade() {
		String grade ="";
		switch(this.totalScore/this.attend) {
			case 0 :
				grade =  "☆";
			case 1 :
				grade = "☆☆";
			case 2 :
				grade = "☆☆☆";
			case 3 :
				grade = "☆☆☆☆";
			case 4 :
			case 5 :
				grade = "☆☆☆☆☆";
		}
		return grade;
	}
	
	public abstract void getInformation();

}

package yhBank.board;

import java.sql.Date;

public class Board {
//	BOARD_NUM     NOT NULL NUMBER         
//	MEMBER_ID     NOT NULL VARCHAR2(20)   
//	BOARD_TITLE   NOT NULL VARCHAR2(200)  
//	BOARD_CONTENT NOT NULL VARCHAR2(1000) 
//	BOARD_DATE             DATE    
	private int boardNum;
	private String memberId;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
}

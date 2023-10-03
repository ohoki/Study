package com.yedam.Ex230517;

public class TossCard extends Card{
	String company = "Toss";
	String cardStaff;
	
	public TossCard(String cardNo, String validDate, String cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}
	
	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card NO, " + cardNo );
		System.out.println("담당직원 - " + cardStaff + ", " + company);
	}
}

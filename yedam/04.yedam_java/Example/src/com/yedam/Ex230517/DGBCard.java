package com.yedam.Ex230517;

public class DGBCard extends Card{
	String company = "대구은행";
	String cardStaff;
	
	public DGBCard(String cardNo, String validDate, String cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}
	
	@Override
	public void showCardInfo() {
		super.showCardInfo();
		System.out.println("담당직원 - " + cardStaff + ", " + company);
	}
}

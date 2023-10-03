package com.yedam.Ex230517;

public class Card {
	String cardNo;
	String validDate;
	String cvc;
	
	public Card(String cardNo, String validDate, String cvc) {
		this.cardNo = cardNo;
		this.validDate = validDate;
		this.cvc = cvc;
	}

	public String getCardNo() {
		return cardNo;
	}

	public String getValidDate() {
		return validDate;
	}

	public String getCvc() {
		return cvc;
	}
	
	public void showCardInfo() {
		System.out.println("카드 정보 ( Card NO : "+ cardNo + ", 유효기간 : " + validDate + ", CVC : " + cvc + " )" );
	}
	
}

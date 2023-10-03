package com.yedam.Ex230517;

public class CardPayment implements Payment {
	double cardRatio;
	
	public CardPayment(double cardRatio) {
		this.cardRatio = cardRatio;
	}

	@Override
	public int online(int price) {
		int result = price - (int)( (cardRatio + Payment.ONLINE_PAYMENT_RATIO)*price );
		return result;
	}

	@Override
	public int offline(int price) {
		int result = price - (int)( (cardRatio + Payment.OFFLINE_PAYMENT_RATIO)*price );
		return result;
	}

	@Override
	public void showInfo() {
		System.out.println("*** 카드로 결제 시 할인정보");
		System.out.println("온라인 결제 시 총 할인율 : " + (cardRatio + Payment.ONLINE_PAYMENT_RATIO) );
		System.out.println("오프라인 결제 시 총 할인율 : " + (cardRatio + Payment.OFFLINE_PAYMENT_RATIO) );
	}

}

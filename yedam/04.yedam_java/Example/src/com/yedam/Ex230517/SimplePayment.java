package com.yedam.Ex230517;

public class SimplePayment implements Payment {
	double cardRatio;
	
	public SimplePayment(double cardRatio) {
		super();
		this.cardRatio = cardRatio;
	}

	@Override
	public int online(int price) {
		price -= (int)( (this.cardRatio + ONLINE_PAYMENT_RATIO)*price );
		return price;
	}

	@Override
	public int offline(int price) {
		price -= (int)( (this.cardRatio + OFFLINE_PAYMENT_RATIO)*price );
		return price;
	}

	@Override
	public void showInfo() {
		System.out.println("*** 간편결제 시 할인정보");
		System.out.println("온라인 결제 시 총 할인율 : " + (this.cardRatio + ONLINE_PAYMENT_RATIO) );
		System.out.println("오프라인 결제 시 총 할인율 : " + (this.cardRatio + OFFLINE_PAYMENT_RATIO) );
	}

}

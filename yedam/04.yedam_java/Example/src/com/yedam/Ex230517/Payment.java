package com.yedam.Ex230517;

public interface Payment {
	public double ONLINE_PAYMENT_RATIO = 0.05;
	public double OFFLINE_PAYMENT_RATIO = 0.03;
	
	public int online(int price);
	public int offline(int price);
	public void showInfo();
}

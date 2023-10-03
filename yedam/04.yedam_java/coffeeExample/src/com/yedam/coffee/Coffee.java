package com.yedam.coffee;

public class Coffee {
//	COFFEE_MENU    NOT NULL VARCHAR2(30)   
//	COFFEE_PRICE   NOT NULL NUMBER         
//	COFFEE_EXPLAIN          VARCHAR2(1000) 
//	COFFEE_SALES            NUMBER    
	private String coffeeMenu;
	private int coffeePrice;
	private String coffeeExplain;
	private int coffeeSales;
	
	public int getTotalSales() {
		return coffeePrice * coffeeSales;
	}
	public String getCoffeeMenu() {
		return coffeeMenu;
	}
	public void setCoffeeMenu(String coffeeMenu) {
		this.coffeeMenu = coffeeMenu;
	}
	public int getCoffeePrice() {
		return coffeePrice;
	}
	public void setCoffeePrice(int coffeePrice) {
		this.coffeePrice = coffeePrice;
	}
	public String getCoffeeExplain() {
		return coffeeExplain;
	}
	public void setCoffeeExplain(String coffeeExplain) {
		this.coffeeExplain = coffeeExplain;
	}
	public int getCoffeeSales() {
		return coffeeSales;
	}
	public void setCoffeeSales(int coffeeSales) {
		this.coffeeSales = coffeeSales;
	}
}

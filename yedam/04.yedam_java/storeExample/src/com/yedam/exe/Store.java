package com.yedam.exe;

public class Store {
//	STORE_ID    NOT NULL NUMBER        
//	STORE_NAME           VARCHAR2(100) 
//	STORE_TEL            VARCHAR2(15)  
//	STORE_ADDR           VARCHAR2(100) 
//	STORE_SALES          NUMBER  
	private int storeId;
	private String storeName;
	private String storeTel;
	private String storeAddr;
	private int storSales;
	private int salesSum;
	
	public int getSalesSum() {
		return salesSum;
	}
	public void setSalesSum(int salesSum) {
		this.salesSum = salesSum;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreTel() {
		return storeTel;
	}
	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}
	public String getStoreAddr() {
		return storeAddr;
	}
	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}
	public int getStorSales() {
		return storSales;
	}
	public void setStorSales(int storSales) {
		this.storSales = storSales;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
}

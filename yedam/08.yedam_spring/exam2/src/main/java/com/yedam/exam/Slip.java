package com.yedam.exam;


public class Slip {
	private  Integer slipNo;   		//전표번호
	private  Integer slipAmount; 	//전표금액
	private  String  slipDt;		//전표일자
	private  String  salDt;			//급녀년월 (YYYYMM)
	private  String  customer;		//거래처(직원) 사번_이름
	private  String  bankAcct;		//지급계좌
	
	public Integer getSlipNo() {
		return slipNo;
	}
	public void setSlipNo(Integer slipNo) {
		this.slipNo = slipNo;
	}
	public Integer getSlipAmount() {
		return slipAmount;
	}
	public void setSlipAmount(Integer slipAmount) {
		this.slipAmount = slipAmount;
	}
	public String getSlipDt() {
		return slipDt;
	}
	public void setSlipDt(String slipDt) {
		this.slipDt = slipDt;
	}
	public String getSalDt() {
		return salDt;
	}
	public void setSalDt(String salDt) {
		this.salDt = salDt;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getBankAcct() {
		return bankAcct;
	}
	public void setBankAcct(String bankAcct) {
		this.bankAcct = bankAcct;
	}
	@Override
	public String toString() {
		return "Slip [slipNo=" + slipNo + ", slipAmount=" + slipAmount + ", slipDt=" + slipDt + ", salDt=" + salDt
				+ ", customer=" + customer + ", bankAcct=" + bankAcct + "]";
	}

}

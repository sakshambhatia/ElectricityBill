package com.cg.electricitybill;

public class Bill {
	private int billId;
	private Boolean paid;
	private float amount;
	private int month;
	private int year;
	
	
	public Bill(int billId, float amount, int month, int year) {
		super();
		this.billId = billId;
		this.paid = false;
		this.amount = amount;
		this.month = month;
		this.year = year;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}

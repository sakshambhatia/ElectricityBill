package com.cg.electricitybill;

import java.util.Stack;

public class Customer {

	private long custId;
	private String name;
	private Stack<Bill> billStack;
	private int connectionNumber;
	
	
	
	public Customer() {
		super();
	}
	public Customer(long custId, String name, Stack<Bill> billStack, int connectionNumber) {
		super();
		this.custId = custId;
		this.name = name;
		this.billStack = billStack;
		this.connectionNumber = connectionNumber;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Stack<Bill> getBillStack() {
		return billStack;
	}
	public void setBillStack(Stack<Bill> billStack) {
		this.billStack = billStack;
	}
	public int getConnectionNumber() {
		return connectionNumber;
	}
	public void setConnectionNumber(int connectionNumber) {
		this.connectionNumber = connectionNumber;
	}
	
	
	
	
	
	
}
	
	


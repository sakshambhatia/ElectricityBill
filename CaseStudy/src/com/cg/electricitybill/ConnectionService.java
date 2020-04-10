package com.cg.electricitybill;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class ConnectionService {
	
	HashMap<Integer, Customer> list = new HashMap<Integer, Customer>(); 
	Customer c = new Customer();
	public int addCustomer(long custId, String name) {
		int connectionNumber = new Random().nextInt(9000) + 1000;
		while(list.containsKey(connectionNumber)) {
			connectionNumber = new Random().nextInt(9000) + 1000;
		}
		Stack<Bill> billStack = new Stack<Bill>();
		c = new Customer(custId,name,billStack,connectionNumber);
		list.put(connectionNumber, c);
		return connectionNumber;
	}
	
	public float billCurrent(int connectionNumber) {
		c = list.get(connectionNumber);
		if(c.getBillStack().empty()) {
			return 0;
		}
		Bill bill = c.getBillStack().peek();
		return bill.getAmount();
	}
	
	public String billPay(int connectionNumber) {
		c = list.get(connectionNumber);
		Bill bill = c.getBillStack().peek();
		if(bill.getPaid())
			return "Already Paid";
		else {
			bill.setPaid(true);
			return "Bill Successfully Paid";
		}	
	}
	public ArrayList<Float> billSixMonths(int connectionNumber) {
		c = list.get(connectionNumber);
		Stack<Bill> billStack = c.getBillStack();
		
		ArrayList<Float> billList = new ArrayList<Float>();
		if(billStack.empty()) {
			billList.add((float) 0);
			return billList;
		}
		int i=0;
		for(Bill bill:billStack) {
			billList.add(bill.getAmount());
			i++;
			if(i==6) {
				break;
			}
		}
		return billList;
		
	}
	public int addConnection(Customer cust) {
		int connectionNumber = new Random().nextInt(9000) + 1000;
		while(list.containsKey(connectionNumber)) {
			connectionNumber = new Random().nextInt(9000) + 1000;
		}
		Stack<Bill> billStack = new Stack<Bill>();
		Customer cust1 = new Customer(cust.getCustId(),cust.getName(),billStack,cust.getConnectionNumber());
		
		list.put(connectionNumber, cust1);
		return connectionNumber;
	}
	public Customer getCustomer(int connectionNumber) {
		
		return list.get(connectionNumber);
	
	}

	public boolean hasConnectionNumber(int connectionNumber) {
		return list.containsKey(connectionNumber);
	}

	public boolean addBill(int connectionNumber, Bill bill) {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		if((bill.getYear()==year && bill.getMonth()>month)||(bill.getYear()>year)||bill.getMonth()>12) {
			return false;
		}
		Customer cust = getCustomer(connectionNumber);
		cust.getBillStack().add(bill);
		return true;
	}
	
	
}

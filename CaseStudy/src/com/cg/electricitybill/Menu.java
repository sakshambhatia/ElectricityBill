package com.cg.electricitybill;


import java.util.ArrayList;
import java.util.Scanner;

	public class Menu {

		public static void main(String[] args) {
			
		Scanner s= new Scanner(System.in);
		ConnectionService conn = new ConnectionService();
		Boolean flag = true;
		while(flag) {	
			System.out.println("Welcome to BSES");
			System.out.println("Are you?");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("0. EXIT");
			String n = s.next(); 
			
	//  -----------------------------------ADMIN STUB--------------------------------------------
			if(n.equals("1")) {
				
				System.out.println("Enter your passcode");
				int pass=s.nextInt();
				
				if(pass!=1234) {
					System.out.println("Passcode incorrect");
					Boolean p=false;
					while(!p) {
						System.out.println("Enter passcode again");
						pass=s.nextInt();
						if(pass==1234) {
							p=true;
						}
					}
				}
				System.out.println("1. Add Customer");
				System.out.println("2. Add Bill");
				System.out.println("3. EXIT");
				String choice1=s.next();
				switch(choice1) {
				case "1":
					System.out.println("Enter Customer Name");
					String name = s.next();
					System.out.println("Enter Your Aadhar Number");
					long custId = s.nextLong();
					System.out.println(conn.addCustomer(custId, name)+" is your connection number");
					break;
				case "2":
					System.out.println("Enter connection Number");
					int connectionNumber = s.nextInt();
					while(!conn.hasConnectionNumber(connectionNumber)) {
						System.out.println("Invalid Connection Number");
						System.out.println("Try Again");
						connectionNumber = s.nextInt();
					}
					System.out.println("Enter billId");
					int billId = s.nextInt();
					System.out.println("Enter amount");
					float amount = s.nextFloat();
					System.out.println("Enter month (MM format)");
					int month = s.nextInt();
					System.out.println("Enter Year (YYYY format)");
					int year = s.nextInt();
					Bill bill=new Bill(billId,amount,month,year);
					if(conn.addBill(connectionNumber, bill)) {
						System.out.println("Successfully added");
					}
					else {
						System.out.println("Unable to add bill");
					}
					break;
				case "3":
					System.out.println("Now Exiting");
					flag=false;
					break;
				default:
					System.out.println("Invalid Choice");
					break;
					
				}
				
			}
	// ---------------------------------------CUSTOMER STUB---------------------------------------
			
			else if(n.equals("2")) {
				System.out.println("Enter your Existing Connection Number");
				int connectionNumber = s.nextInt();
				while(!conn.hasConnectionNumber(connectionNumber)) {
					System.out.println("Invalid Connection Number");
					System.out.println("Try Again");
					connectionNumber = s.nextInt();
				}
				Customer cust = conn.getCustomer(connectionNumber);
				System.out.println("Hello "+cust.getName());
				System.out.println("1. View the recent bill");
				System.out.println("2. Pay current month bill");
				System.out.println("3. View bill for last 6 months");
				System.out.println("4. Request a new connection");
				System.out.println("0. EXIT");
				System.out.println("Make a choice");
				String choice2=s.next();
				
				//Customer c= new Customer();
				switch(choice2) {
					
					case "1": 
						System.out.println(conn.billCurrent(connectionNumber) +" is your current bill");
						break;
					case "2": 
						System.out.println(conn.billPay(connectionNumber));
						break;
					case "3": 
						ArrayList<Float> billList = conn.billSixMonths(connectionNumber);
						for(float bill:billList) {
							System.out.println(bill);
						}
						break;
					case "4": conn.addConnection(cust);
						break;
					
					case "0":
						System.out.println("Now Exiting");
						flag=false;
						break;
					default:
						System.out.println("Invalid Choice");
						break;
				}
				
			}
			else if(n.equals("0")){
				System.out.println("Now Exiting");
				flag=false;
			}
			else {
				System.out.println("Invalid Choice");
			}
				
		
		}
		
		
		s.close();
	
	}


}

	


package com.sanju.Mainclasse;

public class Transaction {
	private String type;
	private double amount;
	private int tragetaccountNo;
	
	public Transaction(String type, double amount,int tragetaccountNo) {
		super();
		this.type = type;
		this.amount = amount;
		this.tragetaccountNo = tragetaccountNo;
	}
 public Transaction(String type,double amount) {
	 this.type = type;
	 this.amount = amount;
 }

	@Override
	public String toString() {
		  if ("Transfer".equals(type)) {
		        return "Transaction [type=" + type + ", amount=" + amount + ", TransferAccountNo=" + tragetaccountNo + "]";
		    } else {
		        return "Transaction [type=" + type + ", amount=" + amount + "]";
		    }
}
}


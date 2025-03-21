package com.sanju;

public class CustomerDetails {
           private  int accountNo = 445556;
           private   int pin = 456123;
			
            public CustomerDetails() {}
            
			public CustomerDetails(int accountNo, int pin) {
				super();
				this.accountNo = accountNo;
				this.pin = pin;
			}
			
			public int getAccountNo() {
				return accountNo;
			}
		
			public int getPin() {
				return pin;
			}
			
			@Override
			public String toString() {
				return "CustomerDetails [accountNo=" + accountNo + ", pin=" + pin + "]";
			}
             
}

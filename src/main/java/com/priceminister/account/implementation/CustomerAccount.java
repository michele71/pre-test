package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {
	double customerBalance = 0;
	
    public void add(Double addedAmount) {
        customerBalance += addedAmount;
    }

    public Double getBalance() {
    	Double balance = new Double(customerBalance);
        
    	return balance!=null?customerBalance:new Double(0.0);
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
    	
        double resultingAccountBalance = customerBalance - withdrawnAmount;

        if(rule.withdrawPermitted(resultingAccountBalance)) {
    		return Math.ceil(resultingAccountBalance);
    	}
    	else {
    		throw new IllegalBalanceException(resultingAccountBalance);
    	}
    }

}

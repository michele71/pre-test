package com.priceminister.account;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;
    private double customerBalance = 0;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
   		this.setUp();
   		customerBalance = customerAccount.getBalance();
   		assertEquals(new Double(0.0), customerBalance);
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
   		this.setUp();
    	customerAccount.add(new Double(2.0));
    	
    	assertEquals(new Double(2.0), customerAccount.getBalance());
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test (expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() {
    	rule = new CustomerAccountRule();

    	customerBalance = customerAccount.withdrawAndReportBalance(customerAccount.getBalance() + 1, rule);
    }
    
}

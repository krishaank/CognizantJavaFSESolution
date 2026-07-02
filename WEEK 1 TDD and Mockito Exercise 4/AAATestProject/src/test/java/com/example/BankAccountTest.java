package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private BankAccount account;

    // The @Before method is used for setup. It executes right before every test method.
    @Before
    public void setUp() {
        System.out.println("Running Setup: Creating a new BankAccount object with $100.0");
        account = new BankAccount(100.0);
    }

    // The @After method is used for teardown. It executes right after every test method.
    @After
    public void tearDown() {
        System.out.println("Running Teardown: Cleaning up after the test");
        account = null;
    }

    @Test
    public void testDepositUsingAAAPattern() {
        // Arrange: Set up the specific inputs and expected outcomes
        double depositAmount = 50.0;
        double expectedBalance = 150.0;

        // Act: Execute the method under test
        account.deposit(depositAmount);
        double actualBalance = account.getBalance();

        // Assert: Verify the results
        assertEquals("Balance should increase to 150.0 after depositing 50.0", 
                     expectedBalance, actualBalance, 0.001);
    }
    
    @Test
    public void testWithdrawUsingAAAPattern() {
        // Arrange: Set up the specific inputs and expected outcomes
        double withdrawAmount = 30.0;
        double expectedBalance = 70.0;

        // Act: Execute the method under test
        account.withdraw(withdrawAmount);
        double actualBalance = account.getBalance();

        // Assert: Verify the results
        assertEquals("Balance should decrease to 70.0 after withdrawing 30.0", 
                     expectedBalance, actualBalance, 0.001);
    }
}

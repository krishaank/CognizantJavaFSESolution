-- Assumptions for schema:
-- Accounts(AccountID, CustomerID, AccountType, Balance)

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Update the balance of all Savings accounts by applying a 1% interest rate
    -- (Current balance + 1% of current balance = Current balance * 1.01)
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
    
    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Successfully processed 1% monthly interest for all Savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        -- Rollback in case of error
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred while processing monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/

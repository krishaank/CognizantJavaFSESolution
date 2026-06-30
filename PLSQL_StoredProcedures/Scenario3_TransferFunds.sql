-- Assumptions for schema:
-- Accounts(AccountID, CustomerID, AccountType, Balance)

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN NUMBER,
    p_target_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_source_balance Accounts.Balance%TYPE;
    
    -- Declare custom exception for insufficient funds
    e_insufficient_funds EXCEPTION;
BEGIN
    -- Validate the transfer amount
    IF p_amount <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Transfer amount must be greater than zero.');
        RETURN;
    END IF;

    -- Lock the source account row to prevent race conditions and get the current balance
    SELECT Balance INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_source_account_id
    FOR UPDATE;
    
    -- Check if source account has sufficient funds
    IF v_source_balance < p_amount THEN
        RAISE e_insufficient_funds;
    END IF;
    
    -- Deduct amount from source account
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_source_account_id;
    
    -- Add amount to target account
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_target_account_id;
    
    -- Commit the transaction if everything is successful
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || 
                         ' from account ' || p_source_account_id || 
                         ' to account ' || p_target_account_id || '.');
    
EXCEPTION
    WHEN e_insufficient_funds THEN
        -- Revert changes if funds are insufficient
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in source account ' || 
                             p_source_account_id || '. Transfer aborted.');
    WHEN NO_DATA_FOUND THEN
        -- Revert changes if account ID does not exist
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Invalid source or target account ID.');
    WHEN OTHERS THEN
        -- Catch-all for any other database errors
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred during funds transfer: ' || SQLERRM);
END TransferFunds;
/

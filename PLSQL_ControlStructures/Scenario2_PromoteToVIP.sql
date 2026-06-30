-- Assumptions for schema:
-- Customers(CustomerID, Name, Age, Balance, IsVIP)

DECLARE
    -- Cursor to fetch all customers
    CURSOR c_customers IS
        SELECT CustomerID, Balance
        FROM Customers;
BEGIN
    -- Iterate through all customers
    FOR rec IN c_customers LOOP
        -- Check if the balance is over $10,000
        IF rec.Balance > 10000 THEN
            -- Update the IsVIP flag to TRUE
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    
    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Successfully promoted eligible customers to VIP status.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating VIP status: ' || SQLERRM);
END;
/

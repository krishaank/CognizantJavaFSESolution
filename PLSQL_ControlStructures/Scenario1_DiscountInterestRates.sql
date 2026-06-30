-- Assumptions for schema:
-- Customers(CustomerID, Name, Age, Balance, IsVIP)
-- Loans(LoanID, CustomerID, InterestRate, DueDate)

DECLARE
    -- Cursor to fetch loans belonging to customers above 60
    CURSOR c_customer_loans IS
        SELECT l.LoanID, l.InterestRate 
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60;
BEGIN
    FOR rec IN c_customer_loans LOOP
        -- Apply a 1% discount to the current loan interest rate
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;
    
    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Successfully applied 1% discount to loans for customers above 60 years old.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating interest rates: ' || SQLERRM);
END;
/

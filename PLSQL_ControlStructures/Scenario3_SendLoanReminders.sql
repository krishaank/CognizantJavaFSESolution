-- Assumptions for schema:
-- Customers(CustomerID, Name, Age, Balance, IsVIP)
-- Loans(LoanID, CustomerID, InterestRate, DueDate)

DECLARE
    -- Cursor to fetch all loans due within the next 30 days
    CURSOR c_loans_due IS
        SELECT c.CustomerID, c.Name, l.LoanID, l.DueDate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    -- Iterate through the fetched loans
    FOR rec IN c_loans_due LOOP
        -- Print a reminder message for each customer
        DBMS_OUTPUT.PUT_LINE('REMINDER: Dear ' || rec.Name || 
                             ' (Customer ID: ' || rec.CustomerID || '), ' ||
                             'your loan account ' || rec.LoanID || 
                             ' is due soon on ' || TO_CHAR(rec.DueDate, 'YYYY-MM-DD') || 
                             '. Please ensure timely payment.');
    END LOOP;
END;
/

# PL/SQL Control Structures Exercises

This folder contains PL/SQL blocks that solve three banking scenarios utilizing cursors and loops.

## Scenarios
1. **Scenario1_DiscountInterestRates.sql**: Loops through all customers, checks their age, and if they are above 60, applies a 1% discount to their current loan interest rates.
2. **Scenario2_PromoteToVIP.sql**: Iterates through all customers and sets a flag `IsVIP` to TRUE for those with a balance over $10,000.
3. **Scenario3_SendLoanReminders.sql**: Fetches all loans due in the next 30 days and prints a reminder message for each customer using `DBMS_OUTPUT`.

## Schema Assumptions
The PL/SQL blocks are written assuming the following generic table structures exist in the database:

### `Customers` Table
- `CustomerID` (Primary Key)
- `Name`
- `Age`
- `Balance`
- `IsVIP` (VARCHAR2/BOOLEAN flag)

### `Loans` Table
- `LoanID` (Primary Key)
- `CustomerID` (Foreign Key referencing `Customers`)
- `InterestRate` (Number/Decimal)
- `DueDate` (Date)

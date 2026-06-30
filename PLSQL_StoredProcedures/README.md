# PL/SQL Stored Procedures Exercises

This folder contains PL/SQL scripts implementing three different stored procedures utilizing database updates, transaction management (COMMIT/ROLLBACK), and exception handling.

## Scenarios
1. **Scenario1_ProcessMonthlyInterest.sql**: Procedure `ProcessMonthlyInterest` calculates and updates the balance of all 'Savings' accounts by applying an interest rate of 1% to the current balance.
2. **Scenario2_UpdateEmployeeBonus.sql**: Procedure `UpdateEmployeeBonus` updates the salary of employees in a specified department by adding a dynamically provided bonus percentage.
3. **Scenario3_TransferFunds.sql**: Procedure `TransferFunds` transfers a specified amount between two accounts. It features transactional integrity, using `SELECT ... FOR UPDATE` to avoid race conditions, and correctly throws exceptions if the source account lacks sufficient funds.

## Schema Assumptions
The PL/SQL blocks are written assuming the following generic table structures exist in the database:

### `Accounts` Table
- `AccountID` (Primary Key)
- `CustomerID`
- `AccountType` (e.g., 'Savings', 'Checking')
- `Balance`

### `Employees` Table
- `EmployeeID` (Primary Key)
- `Name`
- `Department`
- `Salary`

-- Assumptions for schema:
-- Employees(EmployeeID, Name, Department, Salary)

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Validate the bonus percentage
    IF p_bonus_percentage <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Bonus percentage must be greater than zero.');
        RETURN;
    END IF;

    -- Update salary by adding the calculated bonus percentage
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_bonus_percentage / 100))
    WHERE Department = p_department;
    
    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Successfully applied a bonus of ' || p_bonus_percentage || 
                         '% to all employees in the ' || p_department || ' department.');
EXCEPTION
    WHEN OTHERS THEN
        -- Rollback in case of error
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred while updating employee bonuses: ' || SQLERRM);
END UpdateEmployeeBonus;
/

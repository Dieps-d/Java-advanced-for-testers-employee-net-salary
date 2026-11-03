import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: Diepollo
 * Project : EmployeeNetSalaryAssignment
 * DAte:2026/11/03
 **/

public class EmployeeTest {

    Employee employee;

    @BeforeEach
    void setUpEmployee(){
        employee= new Employee(
                "EM111",
                "Mike",
                "Tester",
                Positions.JUNIOR,
                "IT",
                10000
        );
    }

    @Test
    void TestSuccessfulRaiseSalary()throws HighSalaryIncrease{
        double result=employee.raiseSalary(10);
        assertEquals(11000,result);
    }

    @Test
    void TestCalculateHouseAllowance(){
        assertEquals(800,employee.calcHouseAllowance());

    }

    @Test
    void TestCalculateGrossSalary(){
        assertEquals(10800,employee.calcGrossSalary());
    }

    @Test
    void TestCalculateTax(){
        assertEquals(1620,employee.calcTax());
    }
    @Test
    void TestCalculateNetSalary(){
        assertEquals(9180,employee.calcNetSalary());
    }
}

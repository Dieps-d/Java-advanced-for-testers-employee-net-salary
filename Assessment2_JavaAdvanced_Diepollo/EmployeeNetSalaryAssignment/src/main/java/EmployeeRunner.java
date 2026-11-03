/**
 * @author: Diepollo
 * Project : EmployeeNetSalaryAssignment
 * DAte:2026/11/03
 **/

public class EmployeeRunner {
    public static void main(String[] args){

        Employee[] employees=new Employee[4];

        employees[0]=new Employee("EM123","Mike",
                "Developer",Positions.JUNIOR,"IT",25000);

        employees[1]=new Employee("EM124","Thabo",
                "Recruiter",Positions.DIRECTOR,"HR",26000);

        employees[2]=new Employee("EM125","Jessica",
                "Tester",Positions.INTERMEDIATE,"IT",31000);

        employees[3]=new Employee("EM126","Lerato",
                "Accountant",Positions.SENIOR,"FINANCE",34000);


        for (Employee employee:employees){
            try {
                employee.raiseSalary(15);
                employee.promote(7);
                System.out.println(employee);
                System.out.println("++++++++++++++++++++++++++++++");

            } catch (HighSalaryIncrease e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

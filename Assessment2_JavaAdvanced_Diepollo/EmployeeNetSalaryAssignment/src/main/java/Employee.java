/**
 * @author: Diepollo
 * Project : EmployeeNetSalaryAssignment
 * DAte:2026/11/03
 **/

public  class Employee {
    String EmployeeID;
    String EmployeeName;
    double BasicSalary;
    String JobTitle;
    Positions Position;
    String Department;

    public static final double constTax= 0.15;
    public static final double constHouse_Allowance=0.08;

    public Employee(String employeeID, String employeeName, String jobTitle, Positions position,String department, double basicSalary) {
        if (!employeeID.startsWith("EM")){
            throw new IllegalArgumentException("Employee ID must start with EM");
        }

        if (basicSalary<4000){
            throw new IllegalArgumentException("Salary cant be less than R4000");

        }
        this.EmployeeID=employeeID;
       this.EmployeeName=employeeName;
       this.JobTitle=jobTitle;
       this.Position=position;
       this.Department=department;
       this.BasicSalary=basicSalary;

    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public double getBasicSalary() {
        return BasicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        BasicSalary = basicSalary;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public Positions getPosition() {
        return Position;
    }

    public void setPosition(Positions position) {
        Position = position;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    //Methods

    public double raiseSalary(double perc)throws HighSalaryIncrease{
        double increase=BasicSalary*(perc/100);

        if (increase>5000){
            throw new HighSalaryIncrease("Salary increase of " +
                    increase+ "for " + EmployeeName+" is more than the threshhold R5000");
        }
        BasicSalary+=increase;

        return BasicSalary;
    }
    public  Positions promote(int yearsofExperience){
        if (yearsofExperience>=3&&yearsofExperience<=5){
            if (Position==Positions.JUNIOR){
                Position=Positions.INTERMEDIATE;
            } else if (Position==Positions.INTERMEDIATE) {
                Position=Positions.SENIOR;
            }
        } else if (yearsofExperience>=6&&yearsofExperience<=10) {
            if (Position==Positions.INTERMEDIATE){
                Position=Positions.SENIOR;
            } else if (Position==Positions.SENIOR) {
                Position=Positions.DIRECTOR;

            }
        } else if (yearsofExperience>10) {
            if (Position==Positions.SENIOR){
                Position=Positions.DIRECTOR;
            } else if (Position==Positions.DIRECTOR) {
                Position=Positions.EXECUTIVE;
            }
        }
        return Position;
    }
   public  double calcHouseAllowance(){
        return BasicSalary*constHouse_Allowance;
   }
   public double calcGrossSalary(){
        return BasicSalary+calcHouseAllowance();
   }
   public double calcTax(){
       return calcGrossSalary()*constTax;
   }
   public double calcNetSalary(){
        return calcGrossSalary()-calcTax();
   }
   @Override
    public  String toString(){
           return "Employee: ["
                   + EmployeeID +
                   "] "
                   + EmployeeName +
                   "\nTitle: "
                   + JobTitle +
                   "\nPosition: "
                   + Position +
                   "\nDepartment: "
                   + Department +
                   "\n======= Salary Breakdown ======="
                   + "\nBasic: R"
                   + BasicSalary
                   + "\nHouse Allowance: R"
                   + calcHouseAllowance()
                   + "\nGross: R"
                   + calcGrossSalary()
                   + "\nTax Deduction: R"
                   + calcTax()
                   + "\nNet: R"
                   + calcNetSalary();

   }

}


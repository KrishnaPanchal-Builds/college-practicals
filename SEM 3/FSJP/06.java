// To implement Hierarchical Inheritance representing Company Employee records (Employee -> Manager, Employee -> Developer).

// Superclass
class Employee {
    protected int empId;
    protected String name;
    protected double basicSalary;

    public Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public void displayBasicInfo() {
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.printf("Basic Salary  : Rs. %.2f%n", basicSalary);
    }
}

// Subclass 1: Manager
class Manager extends Employee {
    private String department;
    private int teamSize;
    private double performanceBonus;

    public Manager(int empId, String name, double basicSalary, String department, int teamSize, double performanceBonus) {
        super(empId, name, basicSalary);
        this.department = department;
        this.teamSize = teamSize;
        this.performanceBonus = performanceBonus;
    }

    public double calculateTotalSalary() {
        return basicSalary + performanceBonus;
    }

    public void displayManagerDetails() {
        displayBasicInfo();
        System.out.println("Role          : Engineering Manager");
        System.out.println("Department    : " + department);
        System.out.println("Team Size     : " + teamSize + " members");
        System.out.printf("Bonus         : Rs. %.2f%n", performanceBonus);
        System.out.printf("Total Salary  : Rs. %.2f%n", calculateTotalSalary());
        System.out.println("----------------------------------------");
    }
}

// Subclass 2: Developer
class Developer extends Employee {
    private String primaryTechStack;
    private String projectName;
    private double incentive;

    public Developer(int empId, String name, double basicSalary, String primaryTechStack, String projectName, double incentive) {
        super(empId, name, basicSalary);
        this.primaryTechStack = primaryTechStack;
        this.projectName = projectName;
        this.incentive = incentive;
    }

    public double calculateTotalSalary() {
        return basicSalary + incentive;
    }

    public void displayDeveloperDetails() {
        displayBasicInfo();
        System.out.println("Role          : Software Developer");
        System.out.println("Tech Stack    : " + primaryTechStack);
        System.out.println("Project       : " + projectName);
        System.out.printf("Incentive     : Rs. %.2f%n", incentive);
        System.out.printf("Total Salary  : Rs. %.2f%n", calculateTotalSalary());
        System.out.println("----------------------------------------");
    }
}

class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("--- Corporate Employee Management (Hierarchical Inheritance) ---\n");

        Manager mgr = new Manager(1001, "Siddharth Verma", 120000.0, "Platform Engineering", 12, 35000.0);
        Developer dev = new Developer(2004, "Neha Kulkarni", 85000.0, "Java & Spring Boot", "Cloud Migration", 15000.0);

        System.out.println("Manager Record:");
        mgr.displayManagerDetails();

        System.out.println("Developer Record:");
        dev.displayDeveloperDetails();
    }
}

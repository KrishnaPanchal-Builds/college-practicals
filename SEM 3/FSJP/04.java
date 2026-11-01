class UniversityPerson {
    protected String name;
    protected int age;
    protected String gender;
    protected String address;

    public UniversityPerson(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public void displayPersonDetails() {
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Gender  : " + gender);
        System.out.println("Address : " + address);
    }
}

class UniversityStudent extends UniversityPerson {
    private String rollNo;
    private String department;
    private double cgpa;

    public UniversityStudent(String name, int age, String gender, String address, String rollNo, String department, double cgpa) {
        super(name, age, gender, address);
        this.rollNo = rollNo;
        this.department = department;
        this.cgpa = cgpa;
    }

    public void displayStudentDetails() {
        displayPersonDetails();
        System.out.println("Roll No : " + rollNo);
        System.out.println("Dept    : " + department);
        System.out.println("CGPA    : " + cgpa);
        System.out.println("----------------------------------------");
    }
}

class SingleInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("--- University Student Records (Single Inheritance) ---\n");

        UniversityStudent s1 = new UniversityStudent("Rohit Sharma", 20, "Male", "Mumbai, Maharashtra", "CS-2024-042", "Computer Engineering", 9.15);
        UniversityStudent s2 = new UniversityStudent("Pooja Patel", 19, "Female", "Pune, Maharashtra", "IT-2024-088", "Information Technology", 9.42);

        System.out.println("Student 1 Details:");
        s1.displayStudentDetails();

        System.out.println("Student 2 Details:");
        s2.displayStudentDetails();
    }
}

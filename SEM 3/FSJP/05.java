// To represent an educational institution hierarchy using Multilevel Inheritance (AcademicPerson -> CollegeStudent -> PostgraduateStudent).

// Level 1: Base Class
class AcademicPerson {
    protected String name;
    protected int age;
    protected String email;

    public AcademicPerson(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void displayPersonInfo() {
        System.out.println("Name           : " + name);
        System.out.println("Age            : " + age);
        System.out.println("Email          : " + email);
    }
}

// Level 2: Derived Class (inherits from AcademicPerson)
class CollegeStudent extends AcademicPerson {
    protected String studentId;
    protected String department;

    public CollegeStudent(String name, int age, String email, String studentId, String department) {
        super(name, age, email);
        this.studentId = studentId;
        this.department = department;
    }

    public void displayStudentInfo() {
        displayPersonInfo();
        System.out.println("Student ID     : " + studentId);
        System.out.println("Department     : " + department);
    }
}

// Level 3: Derived Class (inherits from CollegeStudent)
class PostgraduateStudent extends CollegeStudent {
    private String specialization;
    private String researchTopic;
    private String guideName;

    public PostgraduateStudent(String name, int age, String email, String studentId, 
                               String department, String specialization, 
                               String researchTopic, String guideName) {
        super(name, age, email, studentId, department);
        this.specialization = specialization;
        this.researchTopic = researchTopic;
        this.guideName = guideName;
    }

    public void displayPostgraduateInfo() {
        displayStudentInfo();
        System.out.println("Specialization : " + specialization);
        System.out.println("Research Topic : " + researchTopic);
        System.out.println("Guide Name     : " + guideName);
        System.out.println("----------------------------------------");
    }
}

class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("--- Postgraduate Student Hierarchy (Multilevel Inheritance) ---\n");

        PostgraduateStudent pg = new PostgraduateStudent(
            "Ananya Iyer",
            24,
            "ananya.iyer@institution.edu",
            "PG-AI-2025-07",
            "Computer Science & Engineering",
            "Artificial Intelligence & Robotics",
            "Autonomous Multi-Agent Coordination in Edge Systems",
            "Dr. K. R. Raman"
        );

        pg.displayPostgraduateInfo();
    }
}

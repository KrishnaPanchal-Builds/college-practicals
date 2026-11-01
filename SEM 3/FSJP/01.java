// To implement a Student class demonstrating Default Constructor, Parameterized Constructor, and Copy Constructor.

class Student {
    private int id;
    private String name;
    private String course;
    private double gpa;

    // Default Constructor
    public Student() {
        this.id = 0;
        this.name = "Unknown";
        this.course = "General";
        this.gpa = 0.0;
    }

    // Parameterized Constructor
    public Student(int id, String name, String course, double gpa) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
    }

    // Copy Constructor
    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.course = other.course;
        this.gpa = other.gpa;
    }

    // Display student information
    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("Course    : " + course);
        System.out.println("GPA       : " + gpa);
        System.out.println("----------------------------------------");
    }
}

class StudentConstructorDemo {
    public static void main(String[] args) {
        System.out.println("--- Student Information Management ---\n");

        // 1. Student with default values
        System.out.println("1. Student created with Default Constructor:");
        Student s1 = new Student();
        s1.display();

        // 2. Student with user-provided values
        System.out.println("2. Student created with Parameterized Constructor:");
        Student s2 = new Student(101, "Alice Johnson", "Computer Science", 9.2);
        s2.display();

        // 3. Student created by copying an existing record
        System.out.println("3. Student created with Copy Constructor (copy of Alice):");
        Student s3 = new Student(s2);
        s3.display();
    }
}

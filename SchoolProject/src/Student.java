public class Student {
    static int counter = 1;

    private String firstName;
    private String lastName;

    // default is -1
    private int grade = -1;
    private int uuid = Student.counter;

    // no default, we do not allow students without names

    Student (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        Student.counter++;
    }

    // uuid (only set at construction, no setter)
    public int getUuid() {
        return this.uuid;
    }

    // grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

    // name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    // output
    public void print () {
        System.out.println("Name: " + this.firstName + " " + this.lastName + " Grade: " + this.grade);
    }
}

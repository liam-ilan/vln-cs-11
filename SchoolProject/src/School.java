import java.util.ArrayList;

public class School {
    String name;
    boolean publicSchool;

    // default is -1
    int rank = -1;

    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    // note: courses is not class defined in the exercise
    // because of this, we never interact with it
    private ArrayList<String> courses = new ArrayList<>();

    School (String name, Boolean publicSchool) {
        this.name = name;
        this.publicSchool = publicSchool;
    }

    // getters
    public ArrayList<String> getCourses() {
        return this.courses;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    public String getName() {
        return this.name;
    }

    public int getRank() {
        return this.rank;
    }

    public boolean isPublicSchool() {
        return this.publicSchool;
    }

    // setters
    public void setRank(int rank) {
        this.rank = rank;
    }

    // Add a teacher to list
    public void addTeacher (Teacher teacher) {
        this.teachers.add(teacher);
    }

    // Add a student to list
    public void addStudent (Student student) {
        this.students.add(student);
    }

    // Delete teacher from list
    public void deleteTeacher (Teacher teacher) {
        this.teachers.remove(teacher);
    }

    // Delete student from list
    public void deleteStudent (Student student) {
        this.students.remove(student);
    }

    // Show all Teachers
    public void showTeachers () {
        this.teachers.forEach((teacher) -> teacher.print());
    }

    // Show all Students
    public void showStudents () {
        this.students.forEach((student) -> student.print());
    }

    // out
    public void print () {
        System.out.println("School Name: " + this.name);
        System.out.println("School Rank: " + (this.rank == -1 ? "N/A" : this.rank));
        System.out.println("Funding: " + (this.publicSchool ? "Public School" : "Private School"));
        System.out.println("TEACHERS");
        this.showTeachers();
        System.out.println("STUDENTS");
        this.showStudents();
    }
}

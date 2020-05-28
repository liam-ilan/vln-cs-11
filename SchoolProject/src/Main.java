public class Main {
    public static void main(String[] args) {
        // names
        String[] firstNames = {
                "Liam",
                "Emma",
                "Noah",
                "Olivia",
                "William",
                "Ava",
                "James",
                "Isabella",
                "Oliver",
                "Sophia",
                "Harper",
                "Logan",
                "Evelyn"
        };

        String[] lastNames = {
                "Smith",
                "Johnson",
                "Williams",
                "Brown",
                "Jones",
                "Miller",
                "Davis",
                "Wilson",
                "Anderson",
                "Taylor"
        };

        String[] subjects = {
                "English",
                "Math",
                "PE",
                "Science",
                "Socials",
                "French",
                "Advanced Home Economics",
                "Drinks"
        };

        // create school
        School churchill = new School ("Churchill", true);
        churchill.setRank(2);

        // add 10 students
        for (int i = 0; i < 10; i++) {
            Student student = new Student(firstNames[i], lastNames[i]);
            student.setGrade((int) Math.floor(Math.random() * 13));
            churchill.addStudent(student);
        }

        // add 3 teachers
        for (int i = 0; i < 3; i++) {
            Teacher teacher = new Teacher(firstNames[9 + i], lastNames[i]);
            teacher.setSubject(subjects[(int) Math.floor(Math.random() * 8)]);
            churchill.addTeacher(teacher);
        }

        // show
        System.out.println("------ BEFORE ------");
        churchill.print();

        // delete first two students
        churchill.deleteStudent(churchill.getStudents().get(0));
        churchill.deleteStudent(churchill.getStudents().get(0));

        // delete teacher
        churchill.deleteTeacher(churchill.getTeachers().get(0));

        // show
        System.out.println("------ AFTER ------");
        churchill.print();
    }
}

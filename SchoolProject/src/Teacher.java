public class Teacher {
    private String firstName;
    private String lastName;
    private String subject = "";

    // no default, we do not allow teachers without names

    Teacher (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
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
        System.out.println("Name: " + this.firstName + " " + this.lastName + " Subject: " + this.subject);
    }
}

package fb;

import java.time.LocalDate;

public class Friend {
    private String name;
    private LocalDate birthDate;
    private String instagramHandle;
    private String homepageURL;

    // Method overloading the constructor to allow for optional parameters
    public Friend(String name) {
        this.name = name;
    }

    public Friend(String name, LocalDate birthDate, String instagramHandle, String homepageURL) {
        this.name = name;
        this.birthDate = birthDate;
        this.instagramHandle = instagramHandle;
        this.homepageURL = homepageURL;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomepageURL() {
        return homepageURL;
    }
    public void setHomepageURL(String homepageURL) {
        this.homepageURL = homepageURL;
    }

    public String getInstagramHandle() {
        return instagramHandle;
    }
    public void setInstagramHandle(String instagramHandle) {
        this.instagramHandle = instagramHandle;
    }

    // Requires: string name, LocalDate birthDate, String instagramHandle, String homepageURL
    // Modifies: this.name, this.birthDate, this.instagramHandle, this.homepageURL
    // Effects: updates all properties to appropriate values
    public void update(String name, LocalDate birthDate, String instagramHandle, String homepageURL) {
        this.name = name;
        this.birthDate = birthDate;
        this.instagramHandle = instagramHandle;
        this.homepageURL = homepageURL;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns the name, birthDate, instagramHandle, and homepageURL, in that order, as a tsv string
    public String toTsv() {
        return this.name + "\t" + this.birthDate + "\t" + this.instagramHandle + "\t" + this.homepageURL;
    }

    // Requires: single row from tsv
    // Modifies: nothing
    // Effects: returns a friend as specified by the tsv
    public static Friend fromTsv(String tsv) {
        String[] values = tsv.split("\t", -1);
        return new Friend(values[0], LocalDate.parse(values[1]), values[2], values[3]);
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns a formated string containing name, birthDate, instagramHandle, and homepageURL
    public String toString(){
        return "Name: " + this.name +
                "\nBirthdate: " + this.birthDate +
                "\nInstagram: " + this.instagramHandle +
                "\nHomepage: " + this.homepageURL;
    }
}

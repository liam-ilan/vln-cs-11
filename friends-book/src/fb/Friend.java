package fb;

import java.util.Date;

public class Friend {
    private String name;
    private Date birthDate;
    private String instagramHandle;
    private String homepageURL;

    // Method overloading the constructor to allow for optional parameters
    public Friend(String name) {
        this.name = name;
    }

    public Friend(String name, Date birthDate, String instagramHandle, String homepageURL) {
        this.name = name;
        this.birthDate = birthDate;
        this.instagramHandle = instagramHandle;
        this.homepageURL = homepageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    public void update(String name, Date birthDate, String instagramHandle, String homepageURL) {
        this.name = name;
        this.birthDate = birthDate;
        this.instagramHandle = instagramHandle;
        this.homepageURL = homepageURL;
    }

    public String toString(){
        return "Name: " + this.name +
                "\nBirthdate: " + this.birthDate +
                "\nInstagram: " + this.instagramHandle +
                "\nHomepage: " + this.homepageURL;
    }
}

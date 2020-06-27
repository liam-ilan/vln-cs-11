import fb.Friend;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

public class FriendTests {
    String name = "John Doe";

    LocalDate birthDate = LocalDate.of(2000, 11, 21);

    String instagramHandle = "theRadJohnD2000";
    String homepageURL = "https://example.com";

    @Test
    public void testFull(){
        Friend friend = new Friend(name, birthDate, instagramHandle, homepageURL);
        assertEquals(name, friend.getName());
        assertEquals(birthDate, friend.getBirthDate());
        assertEquals(instagramHandle, friend.getInstagramHandle());
        assertEquals(homepageURL, friend.getHomepageURL());
    }

    @Test
    public void testOnlyName(){
        Friend friend = new Friend(name);
        assertEquals(name, friend.getName());
        assertNull(friend.getBirthDate());
        assertNull(friend.getInstagramHandle());
        assertNull(friend.getHomepageURL());
    }

    @Test
    public void testToString(){
        Friend friend = new Friend(name, birthDate, instagramHandle, homepageURL);
        assertEquals(
                "Name: " + name +
                        "\nBirthdate: " + birthDate +
                        "\nInstagram: " + instagramHandle +
                        "\nHomepage: " + homepageURL,
                friend.toString()
        );
    }

    @Test
    public void testUpdate(){
        Friend friend = new Friend(
                "placeholder",
                LocalDate.of(2010, 1, 1),
                "mysteryman",
                "https://google.com"
        );

        friend.update(name, birthDate, instagramHandle, homepageURL);

        assertEquals(name, friend.getName());
        assertEquals(birthDate, friend.getBirthDate());
        assertEquals(instagramHandle, friend.getInstagramHandle());
        assertEquals(homepageURL, friend.getHomepageURL());
    }
}
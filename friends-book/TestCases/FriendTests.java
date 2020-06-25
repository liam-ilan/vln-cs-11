import fb.Friend;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

public class FriendTests {
    String name = "John Doe";

    // Note: Date gets years since 1900
    Date birthDate = new Date(100, 11, 21);
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
                new Date(50, 1, 1),
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
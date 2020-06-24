import fb.Friend;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

public class FriendTests {
    String name = "John Doe";
    Date birthDate = new Date(2000, 11, 21);
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
}
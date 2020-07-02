import fb.Book;
import fb.Friend;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BookTests {
    String[] names = {
            "Liam",
            "Charlotte",
            "Oliver",
            "Amelia",
            "Theodore",
            "Violet",
            "Declan",
            "Aria",
            "Henry",
            "Aurora",
            "Owen",
            "Ava",
            "Finn",
            "Olivia",
            "Caleb",
            "Vivienne",
            "Emmett",
            "Hazel",
            "Benjamin",
            "Nora",
    };

    Book book = new Book();

    @Before
    public void setup(){
        for (int i = 0; i < 10; i += 1) {
            String name = names[(int) (Math.random() * names.length)];

            LocalDate birthDate = LocalDate.of(
                    ((int) (Math.random() * 100)) + 1900,
                    1 + ((int) (Math.random() * 12)),
                    1 + ((int) (Math.random() * 28)));

            String homepageURL = "example.com/" + name;
            String instagramHandle = "theLegendary" + name + (int) (Math.random() * 1000);
            Friend person = new Friend(name, birthDate, instagramHandle, homepageURL);

            book.add(person);
        }
    }

    @Test
    public void testAdd(){
        String name = names[(int) (Math.random() * names.length)];

        LocalDate birthDate = LocalDate.of(
                ((int) (Math.random() * 100)) + 1900,
                1 + ((int) (Math.random() * 12)),
                1 + ((int) (Math.random() * 28)));

        String homepageURL = "example.com/" + name;
        String instagramHandle = "theLegendary" + name + (int) (Math.random() * 1000);
        Friend person = new Friend(name, birthDate, homepageURL, instagramHandle);
        book.add(person);

        assertEquals(person, book.getItem(10));
    }

    @Test
    public void testRemove(){
        Friend friend = book.getItem(5);
        book.remove(friend);

        assertEquals(book.getList().size(), 9);
        assertNotEquals(book.getItem(5), friend);
    }

    @Test
    public void testToTsv(){
        String generatedTsv = book.toTsv();

        String expectedTsv = "";
        for (int i = 0; i < book.getList().size(); i += 1) {
            expectedTsv += book.getItem(i).toTsv() + "\n";
        }

        assertEquals(expectedTsv, generatedTsv);
    }

    @Test
    public void testFromTsv(){
        String tsv = book.toTsv();
        Book newBook = Book.fromTsv(tsv);

        for (int i = 0; i < book.getList().size(); i++) {
            assertEquals(book.getItem(i).getName(), newBook.getItem(i).getName());
            assertEquals(book.getItem(i).getBirthDate(), newBook.getItem(i).getBirthDate());
            assertEquals(book.getItem(i).getInstagramHandle(), newBook.getItem(i).getInstagramHandle());
            assertEquals(book.getItem(i).getHomepageURL(), newBook.getItem(i).getHomepageURL());
        }
    }
}
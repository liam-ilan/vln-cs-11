package fb;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
    private ArrayList<Friend> list;

    public Book() {
        this.list = new ArrayList<Friend>();
    }

    // Requires: Friend
    // Modifies: list
    // Effects: appends friend to list
    public void add(Friend friend) {
        list.add(friend);
    }

    // Requires: Friend
    // Modifies: list
    // Effects: removes friend from list
    public void remove(Friend friend) {
        list.remove(friend);
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns a tsv string of all items in the book
    public String toTsv() {
        String res = "";

        for (int i = 0; i < list.size(); i++) {
            res += list.get(i).toTsv() + "\n";
        }

        return res;
    }

    // Requires: tsv String
    // Modifies: nothing
    // Effects: returns a Book as specified by the tsv
    public static Book fromTsv(String tsv) {
        Book res = new Book();
        for (String line : tsv.split("\n")) {
            if (line != "") {
                res.add(Friend.fromTsv(line));
            }
        }

        return res;
    }

    // Requires: path
    // Modifies: nothing
    // Effects: returns a Book as specified by the file in the path
    public static Book fromFile(String path) throws IOException {
        String data = "";

        // create file stream
        FileInputStream in = new FileInputStream(path);

        // current letter in loop
        char letter;

        // write to res for each char is stream
        while((letter = (char) in.read()) != (char) -1){
            data += letter;
        }

        return Book.fromTsv(data);
    }

    // Requires: path
    // Modifies: file specified at path
    // Effects: writes tsv of book to path
    public void toFile(String path) throws IOException {
        FileWriter fw = new FileWriter(path, false);
        fw.write(this.toTsv());
        fw.close();
    }

    public ArrayList<Friend> getList() { return list; }
    public Friend getItem(int index) { return list.get(index); }
    public Friend setItem(int index, Friend friend) { return list.set(index, friend); }
}

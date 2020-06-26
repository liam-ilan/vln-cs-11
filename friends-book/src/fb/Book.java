package fb;

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

    public ArrayList<Friend> getList() { return list; }
    public Friend getItem(int index) { return list.get(index); }
    public Friend setItem(int index, Friend friend) { return list.set(index, friend); }
}

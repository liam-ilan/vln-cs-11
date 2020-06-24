package fb;

import java.util.ArrayList;

public class Book {
    private ArrayList<Friend> list;

    Book() {
        this.list = new ArrayList<Friend>();
    }

    public void add(Friend friend) {
        list.add(friend);
    }

    public void remove(Friend friend) {
        list.remove(friend);
    }

    public ArrayList<Friend> getList() {
        return list;
    }
}

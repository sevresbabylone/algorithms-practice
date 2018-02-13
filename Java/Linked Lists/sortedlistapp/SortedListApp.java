package sortedlistapp;

import sortedlist.SortedList;

public class SortedListApp {
    public static void main(String[] args) {
        SortedList sortedListA = new SortedList();
        sortedListA.insert(12);
        sortedListA.insert(1);
        sortedListA.insert(44);
        sortedListA.insert(10);
        sortedListA.displayList();
    }
}

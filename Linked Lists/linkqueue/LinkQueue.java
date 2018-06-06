package linkqueue;

// insert in back
// remove in front
// display queue
// check if empty
// HINT: use double ended list

import doubleendedlist.DoubleEndedList;

public class LinkQueue {
    private DoubleEndedList queue;
    public LinkQueue() {
        queue = new DoubleEndedList();
    }
    public void insert(int j) {
        queue.insertLast(j);
    }
    public int remove() {
        return queue.deleteFirst().iData;
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public void displayQueue() {
        queue.displayList();
    }
}

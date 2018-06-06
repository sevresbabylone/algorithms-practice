package listiterator;

import link.Link;
import linkedlist.LinkedList;

// Methods required:
// reset() Sets the iterator to the start of the list
// nextLink() Moves the iterator to the next link
// getCurrent() Returns the link at the iterator
// atEnd() Returns true if the iterator is at the end of the list
// insertAfter() Inserts a new link after the iterator
// insertBefore() Inserts a new link before the iterator • deleteCurrent()—Deletes the link at the iterator

public class ListIterator {
    private Link current;
    private Link previous;
    private LinkedList parentList;

    public ListIterator(LinkedList list) {
        parentList = list;
        reset();
    }

    public void reset() {
    current = parentList.getFirst(); // public method that allows iterator to access private variable
    previous = null;
    }

    public boolean atEnd() {
        return current.next == null;
    }
    public void nextLink() {
        if (current.next != null) {
            previous = current;
            current = current.next;
        }
        else {
            System.out.println("At last link, hit reset to go to first link!");
        }
    }
    public Link getCurrent() {
        return current;
    }
    public void insertAfter(int data) {
        Link newLink = new Link(data);
        if (parentList.isEmpty()) {
            parentList.setFirst(newLink);
            current = newLink;
        }
        else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink(); // point to new link
        }
    }
    public void insertBefore(int data) {
        Link newLink = new Link(data);
        if (previous == null) { // at first link or list is empty
            newLink.next = parentList.getFirst();
            parentList.setFirst(newLink);
            reset();
        }
        else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }

    }
    public int deleteCurrent() {
        int value = current.iData;
        if (previous == null) { // if deleting first Link
            parentList.setFirst(current.next);
            reset();
        }
        else {
            previous.next = current.next;
            if (atEnd()) reset();
            else current = current.next;
        }
        return value;
    }
}
package doubleendedlist;

// Same as LinkedList but with reference to last Link
// Methods required:
// Method to check if list is empty
// Insert first Link
// Insert last Link
// Delete first Link
// Display contents of LinkedList

import link.Link;

public class DoubleEndedList {
    private Link first;
    private Link last;
    public DoubleEndedList() {
        first = null;
        last = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void insertFirst(int data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
        if( isEmpty() ) {
            last = newLink;
        }
    }
    public void insertLast(int data) {
        Link newLink = new Link(data);
        if( isEmpty() ) {
            first = newLink;
        }
        else {
            last.next = newLink;
        }
        last = newLink;
    }
    public Link deleteFirst() {
        // if list only has one Link, assumes non-empty list
        Link temp = first;
        if (first.next == null ) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List ( first --> last): ");
        Link current = first;
        while(current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

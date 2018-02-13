package sortedlist;

import link.Link;
// Insertion and deletion of items in sorted linked list = O(N) comparisons, N/2 on average
// Minimum: O(1)
public class SortedList {
    private Link first;
    public SortedList() {
        first = null;
    }
    public void insert(int iData) {
        Link newLink = new Link(iData);
        Link previous = null;
        Link current = first;
        while (current != null && iData > current.iData) {
            previous = current; // not a doubly linked list, keep track of previous link
            current = current.next;
        }
        if(previous == null) {
            first = newLink;
        }
        else {
            previous.next = newLink;
        }
        newLink.next = current;

    }
    public boolean isEmpty() {
        return first == null;
    }
    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }
    public void displayList() {
        Link current = first;
        while(current != null) {
            current.displayLink();
            current = current.next;
        }
    }
}

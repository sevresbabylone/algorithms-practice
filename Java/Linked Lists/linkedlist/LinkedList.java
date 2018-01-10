package linkedlist;

// Methods required:
// Method to check if list is empty
// Insert first Link
// Delete first Link
// Display contents of LinkedList
// Find Link with specific key value
// Delete Link with specific key value
// Insert Link after Link with specific key value

import link.Link;

public class LinkedList {
    private Link first;
    public void LinkedList() {
        first = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void insertFirst(int iData) {
        Link newLink = new Link(iData);
        newLink.next = first;
        first = newLink;
    }
    public Link deleteFirst() {
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
    public Link find(int key) {
        Link current = first;
        while(current.iData != key) {
            if(current.next == null) {
                return null;
            }
            else {
                current = current.next;
            }
        }
        return current;
    }
    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while(current.iData != key) {
            if(current.next == null) {
                return null;
            }
            else {
                previous = current;
                current = current.next;
            }
        }
        if(current == first) {
            first = first.next;
        }
        else {
            previous.next = current.next;
        }
        return current;
    }
}

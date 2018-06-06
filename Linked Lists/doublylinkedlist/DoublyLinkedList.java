package doublylinkedlist;

import link.Link;

public class DoublyLinkedList {
    private Link first;
    private Link last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void insertFirst(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            last = newLink;
        } else {
            newLink.next = first;
            first.previous = newLink;
        }
        first = newLink;
        first.previous = null;
    }
    public void insertLast(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }
    public boolean insertAfter(int key, int data) {
        Link current = first;
        while(current.iData != key) {
            current = current.next;
            if (current == null) {
                System.out.println("Key not found!");
                return false;
            }
        }
        Link newLink = new Link(data);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        }
        else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }
    public Link deleteKey(int key) {
        Link current = first;
        while(current.iData != key) {
            current = current.next;
            if (current == null) {
                System.out.println("Key not found!");
                return null;
            }
        }
        if(current == first) {
            first = current.next;
            first.previous = null;
        }
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        if(current == last) {
            last = current.previous;
            last.next = null;
        }
        else {
            current.next.previous = current.previous;
            current.previous.next = current.next;
        }
        return current;
    }
    public void displayForwards() {
        Link current = first;
        System.out.println("Displaying first -> last");
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }
    public void displayBackwards() {
        Link current = last;
        System.out.println("Displaying last -> first");
        while(current != null) {
            current.displayLink();
            current = current.previous;
        }

    }
}

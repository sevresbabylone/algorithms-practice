package doublylinkedlistapp;

import doublylinkedlist.DoublyLinkedList;

public class DoublyLinkedListApp {
    public static void main(String[] args) {
        DoublyLinkedList DElist = new DoublyLinkedList();
        DElist.insertFirst(32);
        DElist.insertFirst(42);
        DElist.insertFirst(44);
        DElist.insertLast(66);
        DElist.insertFirst(55);
        DElist.insertLast(90);
        DElist.insertAfter(44, 36);
        DElist.displayForwards();
        DElist.deleteKey(36);
        DElist.displayBackwards();
    }
}

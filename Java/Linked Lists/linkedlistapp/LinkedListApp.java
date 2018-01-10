package linkedlistapp;

import linkedlist.LinkedList;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList listA = new LinkedList();
        System.out.println(listA.isEmpty());
        listA.insertFirst(22);
        listA.insertFirst(33);
        listA.insertFirst(44);
        listA.delete(22);
        listA.displayList();
    }
}


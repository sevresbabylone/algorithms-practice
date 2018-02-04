package linkstack;

// demonstrates a stack implemented as a list
// void push
// long pop
// boolean isEmpty
// void displayStack

import linkedlist.LinkedList;

public class LinkStack {
    private LinkedList stack;
    public LinkStack() {
        stack = new LinkedList();
    }
    public void push(int j) {
        stack.insertFirst(j);
    }
    public int pop() {
        return stack.deleteFirst().iData;
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public void displayStack() {
        System.out.println("Stack:");
        stack.displayList();
    }
}

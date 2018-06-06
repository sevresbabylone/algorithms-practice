package priorityapp;

import priorityqueue.PriorityQueue;

public class PriorityApp {
    public static void main(String[] args) {
        PriorityQueue examplePQ = new PriorityQueue(5);
        examplePQ.insert(30);
        examplePQ.insert(50);
        examplePQ.insert(10);
        examplePQ.insert(40);
        examplePQ.insert(20);

        while(!examplePQ.isEmpty()) {
            long item = examplePQ.remove();
            System.out.print(item + " ");
        }
        System.out.println("");
    }
}

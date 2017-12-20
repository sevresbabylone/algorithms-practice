package queueapp;

import queue.Queue;

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
//        theQueue.remove();
//        theQueue.remove();
//        theQueue.remove();
//        theQueue.insert(50);
//        theQueue.insert(60);
//        theQueue.insert(70);
//        theQueue.insert(80);

//        while(!theQueue.isEmpty()) {
//            System.out.print(theQueue.remove() + " ");
//        }
        System.out.println(theQueue.size());
// queue holds 5 items // insert 4 items
// remove 3 items // (10, 20, 30)
// insert 4 more items // (wraps around)

    }
}

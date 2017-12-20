package priorityqueue;

public class PriorityQueue {
    private long[] queueArray;
    private int maxSize;
    private int nItems;

    public PriorityQueue(int s) {
        maxSize = s;
        queueArray = new long[maxSize];
        nItems = 0;
    }
    public void insert(long value) {
        int j;
        if(nItems == 0) {
            queueArray[nItems++] = value;
        }
        else {
            // smallest = higher priority
            for (j = nItems - 1; j >= 0; j--) {
                if (queueArray[j] < value)
                    queueArray[j + 1] = queueArray[j];
                else
                    break;
            }

            queueArray[j + 1] = value;
            nItems++;
        }
    }
    public long remove() {
        return queueArray[--nItems];
    }
    public long peekMin() { // peek at minimum Item
        return queueArray[nItems-1];

    }
    public boolean isEmpty() {
        return nItems == 0;
    }
    public boolean isFull() {
        return nItems == maxSize;
    }

}

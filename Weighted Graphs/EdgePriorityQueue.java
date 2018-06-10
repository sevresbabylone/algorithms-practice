public class EdgePriorityQueue {
    private final int SIZE = 20;
    private Edge[] queueArray;
    private int size;
    public EdgePriorityQueue() {
        queueArray = new Edge[SIZE];
        size = 0;
    }
    public void insert(Edge item) {
        int i;
        for (i = 0; i < size; i++) {
            if (item.weight >= queueArray[i].weight) {
                break; }
        }
        for (int j = size - 1; j > i; j--) {
            queueArray[j+1] = queueArray[j];
        }
        queueArray[i] = item;
        size++;
    }
    public Edge removeMinimum() {
        return queueArray[--size];
    }
    public void removeN(int n) {
        for(int j = n; j < size - 1; j++) {
            queueArray[j] = queueArray[j+1];
        }
    }
    public Edge peekMinimum() {
        return queueArray[size-1];
    }
    public boolean isEmpty() {
        return queueArray.length == 0;
    }
    // returns index of item with identical destination value
    public int find (int destination) {
        for (int i = 0; i < size; i++) {
            if (queueArray[i].destination == destination) {
                return i;
            }
        }
        return -1;
    }
    public Edge getEdgeAtN(int n) {
        return queueArray[n];
    }
}

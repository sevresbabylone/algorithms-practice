// Array-based heap

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int max) {
        maxSize = max;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }
    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }
    public void boolean trickleUp(int index) {
        int parent = (index - 1) / 2;

        Node parent = heapArray[parent];
        Node bottom = heapArray[index];
        // keep moving parent nodes down while parent is less than inserted node OR have reached the top node
        while(index > 0 && heapArray[index].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }
    public Node remove() {

    }
    public void trickleDown(int index) {

    }
    public void displayHeap() {

    }
}
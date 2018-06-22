// Array based heap

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
    public void trickleUp(int index) {
        int parent = (index - 1) / 2;

        Node bottom = heapArray[index];
        // keep moving parent nodes down while parent is less than inserted node OR have reached the top node
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {

            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }
    public Node remove() {
        // detach root, reattach last node and then trickle down
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }
    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index]; // save root
        while (index < currentSize / 2 ) { // while not on bottom row
            int leftChildIndex = (2 * index) + 1;
            int rightChildIndex = (2 * index) + 2;
            if (rightChildIndex < currentSize) { // if right child exists
                largerChild = (heapArray[leftChildIndex].getKey() > heapArray[rightChildIndex].getKey()) ? leftChildIndex : rightChildIndex;
            }
            else {
                largerChild = leftChildIndex;
            }
            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }
            heapArray[index] = heapArray[largerChild]; // move largerChild up
            index = largerChild;
        }
        heapArray[index] = top;
    }
    // method that changes the priority (iData) of a node and trickles it up or down to its correct position
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) { // if index invalid, return false
            return false;
        }
        int oldValue = heapArray[index].getKey(); // record old value
        heapArray[index].setKey(newValue);
        if (oldValue > newValue) {
            trickleDown(index);
        }
        else {
            trickleUp(index);
        }
        return true;
    }
    public void displayHeap() {
        System.out.print("heapArray:");
        for (int m = 0; m < currentSize; m++) {
            if (heapArray[m] != null) {
                System.out.print(heapArray[m].getKey() + " ");
            }
            else {
                System.out.print("--");
            }
        }
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;

        while (currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize)
                break;
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            }
            else {
                for (int k = 0; k < nBlanks*2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println('\n');
    }
    public void incrementSize() {
        currentSize++;
    }
    public void insertAt(int index, Node newNode) {
        heapArray[index] = newNode;
    }
    public void heapify(int index) {
        if (index > currentSize / 2 - 1) return; // if node has no children, return
        heapify(index * 2 + 2); // turn right subtree into heap
        heapify(index * 2 + 1); // turn left subtree into heap
        trickleDown(index); // apply trickleDown to current node
    }
    public void toss(int key) {
        Node newNode = new Node(key);
        heapArray[currentSize++] = newNode;
    }
    public void restoreHeap() {
        for (int j = currentSize / 2 - 1; j >= 0; j--) {
            trickleDown(j);
       }
    }
}

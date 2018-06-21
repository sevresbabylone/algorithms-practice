// Ascending Heap: Smallest numbers on top

public class AscendingHeap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public AscendingHeap(int max) {
        maxSize = max;
        heapArray = new Node[maxSize];
        currentSize = 0;
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
        int parent = ( index - 1 ) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getKey() > bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = ( index - 1 ) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int smallerChild;
        Node top = heapArray[index];
        while(index < currentSize / 2) {
            int leftChildIndex =  (2 * index) + 1;
            int rightChildIndex = (2 * index) + 2;
            if (rightChildIndex < currentSize) {
                smallerChild = (heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey() ? leftChildIndex : rightChildIndex);
            }
            else {
                smallerChild = leftChildIndex;
            }
            if (top.getKey() <= heapArray[smallerChild].getKey()) {
               break;
            }
            heapArray[index] = heapArray[smallerChild];
            index = smallerChild;
        }
        heapArray[index] = top;
    }

    public void displayHeap() {
        System.out.print("heapArray:");
        for (int m = 0; m < currentSize; m++) {
            if (heapArray[m] != null) {
                System.out.print(heapArray[m].getKey() + " ");
            } else {
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
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println('\n');
    }

}

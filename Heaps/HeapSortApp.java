import java.util.Arrays;

public class HeapSortApp {
    public static void main(String[] args) {
        int[] arrayToSort = new int[] {23, 1, 2, 90, 123, 29, 11, 55, 20, 10};
        // sort from largest to smallest = > 1, 2, 10, 11, 20, 23, 29, 55, 90, 123
        System.out.println(Arrays.toString(arrayToSort));
        heapSort(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));
    }

    public static void heapSort(int[] arrayToSort) {
        int j, size;
        size = arrayToSort.length;
        // create new heap
        Heap sortableHeap = new Heap(size);
        // purely to demonstrate creating a correct heap w/o use of trickleUp, create incorrect heap by pushing values
        // this saves N / 2 applications of trickleDown O(log N)
        for (j = 0; j < size; j++) {
            Node newNode = new Node(arrayToSort[j]);
            sortableHeap.insertAt(j, newNode);
            sortableHeap.incrementSize();
        }
        // use trickleDown on heap starting from index (N / 2) - 1 to make correct heap
        // iterative
//         for (j = size / 2 - 1; j >= 0; j--) {
//            sortableHeap.trickleDown(j);
//         }

         // recursive (less efficient)
        sortableHeap.heapify(0);
        for (j = size-1; j >= 0; j--) {
            Node biggestNode = sortableHeap.remove();
            arrayToSort[j] = biggestNode.getKey();
        }
    }
}

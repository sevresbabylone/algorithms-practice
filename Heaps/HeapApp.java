import java.io.IOException;

public class HeapApp {
    public static void main(String[] args) throws IOException {
        Heap heap1 = new Heap(31);
        heap1.insert(70);
        heap1.insert(40);
        heap1.insert(50);
        heap1.insert(20);
        heap1.insert(60);
        heap1.insert(100);
        heap1.insert(80);
        heap1.insert(30);
        heap1.insert(10);
        heap1.insert(90);
        heap1.insert(120);
        heap1.displayHeap();
        heap1.remove();
        heap1.change(0, 50);
        heap1.displayHeap();

        AscendingHeap heap2 = new AscendingHeap(30);
        heap2.insert(70);
        heap2.insert(40);
        heap2.insert(50);
        heap2.insert(20);
        heap2.insert(60);
        heap2.insert(100);
        heap2.insert(80);
        heap2.insert(30);
        heap2.insert(10);
        heap2.insert(90);
        heap2.insert(120);
        heap2.displayHeap();
        heap2.remove();
        heap2.displayHeap();
    }
}

// 10 30 100 80 120 100 100 70 60 90 120
// 70 40  50 20  60 100  80 30 10 90 120
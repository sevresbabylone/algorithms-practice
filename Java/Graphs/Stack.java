public class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public Stack(int max) {
        maxSize = max;
        stackArray = new int[maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public int pop() {
        int x = stackArray[top--];
        return x;
    }

    public boolean push(int j) {
        if (top >= maxSize) {
            System.out.println("Stack overflow");
            return false;
        } else {
            stackArray[++top] = j;
            return true;
        }
    }

    public int size() {
        return top + 1;
    }

    public int peek() {
        return stackArray[top];
    }

    public int peekN(int n) {
        return stackArray[n];
    }

    public void displayStack() {
        System.out.print("Stack from bottom to top: ");
        for (int i = 0; i < top; i++) {
            System.out.print(peekN(i));
        }
        System.out.println("");
    }
}
package stackx;

public class StackX {
    private int maxSize;
    private int top;
    private char[] stackArray;

    public StackX(int max) {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public char pop() {
        char x = stackArray[top--];
        return x;
    }
    public boolean push(char j) {
        if(top >= maxSize) {
            System.out.println("Stack overflow");
            return false;
        }
        else {
            stackArray[++top] = j;
            return true;
        }
    }
}


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
    public int size() {
        return top+1;
    }
    public char peek() {
        return stackArray[top];
    }
    public char peekN(int n) {
        return stackArray[n];
    }
    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack from bottom to top: ");
        for(int i=0; i<top; i++) {
            System.out.print( peekN(i));
        }
        System.out.println("");

    }
}


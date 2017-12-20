package reverser;
import stackx.StackX;

public class Reverser {
    private String input;
    private String output;

    public Reverser (String in) {
        input = in;
    }
    public String doRev() {
        int stackSize = input.length();
        StackX reverseStack = new StackX(stackSize);
        for(int j=0; j<input.length(); j++) {
            char ch = input.charAt(j);
            reverseStack.push(ch);
        }
        output = "";
        while(!reverseStack.isEmpty()) {
            char ch = reverseStack.pop();
            output = output + ch;
        }
        return output;
    }
}

package bracketchecker;

import stackx.StackX;

public class BracketChecker {
    private String input;

    public BracketChecker(String in) {
        input = in;
    }
    public void check() {
        int stackSize = input.length();
        StackX bracketStack = new StackX(stackSize);

        for(int j=0; j<input.length(); j++) {
            char ch = input.charAt(j);
            switch(ch) {
                case '{':
                case '[':
                case '(':
                    bracketStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!bracketStack.isEmpty()) {
                        char chx = bracketStack.pop();
                        if ((ch == '}' && chx != '{') ||(ch == ']' && chx != '[') || (ch == ')' && chx != '('))
                        System.out.println("Error:" + ch + " at " + j);
                    }
                    else
                        System.out.println("Error: " + ch + " at " + j);
                    break;
                default:
                    break;
            }
        }
        if( !bracketStack.isEmpty())
            System.out.println("Error: missing right delimiter");
    }
}
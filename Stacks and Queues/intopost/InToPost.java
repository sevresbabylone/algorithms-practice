package intopost;

import stackx.StackX;

public class InToPost {
    private StackX operatorStack;
    private String input;
    private String output = "";

    public InToPost(String in) {
        input = in.replaceAll("\\s", "");
        int stackSize = input.length();
        operatorStack = new StackX(stackSize);
    }
    public String doTrans() {
        for(int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            switch(ch) {
                case '^':
                    handleOperator(ch, 2);
                    break;
                case '*':
                case '/':
                    handleOperator(ch, 1);
                    break;
                case '+':
                case '-':
                    handleOperator(ch, 0);
                    break;
                case '(': // just push it onto the stack
                    operatorStack.push(ch);
                    break;
                case ')': // resolve everything inside the parentheses i.e. until you hit '('
                    handleRightParen();
                    break;
                default: // operand: just output it
                    output = output + ch;
                    break;
            }
        }
        // end of input string, append remaining operators from stack
        while(!operatorStack.isEmpty()) {
            output = output + operatorStack.pop();
        }
        return output;
    }
    public void handleOperator(char opThis, int precedence) {
        char opTop;
        int opTopPrecedence = -1;
        if (operatorStack.isEmpty()) { // if stack empty, just push operator onto stack
            operatorStack.push(opThis);
        }
        else {
            while(!operatorStack.isEmpty()) {
                opTop = operatorStack.pop();
                switch(opTop) {
                    case '^':
                        opTopPrecedence = 2;
                        break;
                    case '*':
                    case '/':
                        opTopPrecedence = 1;
                        break;
                    case '+':
                    case '-':
                        opTopPrecedence = 0;
                        break;
                    case '(':
                        opTopPrecedence = -1;
                        break;
                }
               if (opTopPrecedence < precedence ) {

                   operatorStack.push(opTop);
                    break;
                }
                else {
                   output += opTop;
                   break;
               }
            }
            operatorStack.push(opThis);

        }
    }
    public void handleRightParen() {
        char opTop;
        while(!operatorStack.isEmpty()) {
            opTop = operatorStack.pop();
            if(opTop == '(') {
                break;
            }
            else {
                output = output + opTop;
            }
        }
    }

}

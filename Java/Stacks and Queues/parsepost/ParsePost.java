package parsepost;

import parsestack.ParseStack;
import java.lang.Math;

// Operand: Push it onto the stack.
// Operator: Pop the top two operands from the stack and apply the operator to them. Push the result.

public class ParsePost {
    private ParseStack parseStack;
    private char[] input;

    public ParsePost(String inputString) {
        input = inputString.toCharArray();
    }
    public int parseString() {
        parseStack = new ParseStack(input.length);
        char ch;
        int operand1, operand2, operationResult;
        for (int j=0; j<input.length;j++) {
            ch = input[j];
            if (Character.isDigit(ch)) {
                parseStack.push((Character.getNumericValue(ch)));
            }
            else {
                operand2 = parseStack.pop();
                operand1 = parseStack.pop();
                switch(ch) {
                    case '+':
                        operationResult = operand1 + operand2;
                        break;
                    case '-':
                        operationResult = operand1 - operand2;
                        break;
                    case '/':
                        operationResult = operand1 / operand2;
                        break;
                    case '*':
                        operationResult = operand1 * operand2;
                        break;
                    case '^':
                        operationResult = (int) Math.pow(operand1, operand2);
                        break;
                    default:
                        operationResult = 0;
                }
                parseStack.push(operationResult);
            }
        }
        operationResult = parseStack.pop();
        return operationResult;
    }
}

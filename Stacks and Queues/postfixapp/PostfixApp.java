package postfixapp;

import parsepost.ParsePost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostfixApp {
    public static void main(String[] args) throws IOException {
        String input;
        int output;
        while (true) {
           System.out.print("Enter postfix: ");
           System.out.flush();
           input = getString();
           if(input.equals("")) break;
           ParsePost parser = new ParsePost(input);
           output = parser.parseString();
           System.out.println("Evaluates to " + output);
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}

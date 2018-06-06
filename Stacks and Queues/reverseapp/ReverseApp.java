package reverseapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import reverser.Reverser;

public class ReverseApp {
    public static void main(String[] args) throws IOException {
        String input;
        String output;
        while(true) {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString();
            if( input.equals(""))
                break;
            Reverser exampleReverser = new Reverser(input);
            output = exampleReverser.doRev();
            System.out.println("Reversed " + output);
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

package infixapp;

import intopost.InToPost;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while(true)
        {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString(); // read a string from keyboard
            if( input.equals("") ) break;
            // make a translator
            InToPost stringToTranslate = new InToPost(input);
            output = stringToTranslate.doTrans(); // do the translation
            System.out.println("Postfix is " + output + "\n");
        }
    }
    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

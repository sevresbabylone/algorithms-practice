package iteratorapp;

import linkedlist.LinkedList;
import listiterator.ListIterator;

import java.util.Scanner;

public class IteratorApp {
    public static void main(String[] args) {
        LinkedList listA = new LinkedList();
        ListIterator iteratorA = listA.getIterator();
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int value;
        boolean active = true;

        iteratorA.insertAfter(1);
        iteratorA.insertAfter(2);
        iteratorA.insertAfter(3);
        iteratorA.insertAfter(4);

        while (active) {
            System.out.print("Please enter one of these choices \n");
            System.out.print("n: Iterate to next link \n" +
                             "g: Display current link \n" +
                             "s: Show List \n" +
                             "r: Reset current to first link \n" +
                             "b: Insert new Link before current link \n" +
                             "a: Insert new Link after current Link \n" +
                             "d: Delete current link \n" +
                             "q: Quit \n");

            char choice = sc.nextLine().charAt(0);
            switch (choice) {
                case 'n' :
                    iteratorA.nextLink();
                    break;
                case 'g' :
                    int iData = iteratorA.getCurrent().iData;
                    System.out.println("Returned value: " + iData);
                    break;
                case 's' :
                    if (!listA.isEmpty()) {
                        listA.displayList();
                    }
                    else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'r' :
                    iteratorA.reset();
                    break;
                case 'b' :
                    System.out.print("Enter value to insert: \n");
                    System.out.flush();
                    int numB = in.nextInt();
                    iteratorA.insertBefore(numB);
                    break;
                case 'a' :
                    System.out.print("Enter value to insert: \n");
                    System.out.flush();
                    int numA = in.nextInt();
                    iteratorA.insertAfter(numA);
                    break;
                case 'd' :
                    System.out.print("Link with iData: " + iteratorA.deleteCurrent() + " deleted \n");
                    break;
                case 'q' :
                    active = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

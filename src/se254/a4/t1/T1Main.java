package se254.a4.t1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * SE254 Assignment 4 Task 1 Main
 * 
 * This class is implemented to accept the classname input through args[0] and
 * delegate the reflection functionality to class Reflector. If args[0] is not
 * provided would ask user for classname. An object would be created from the
 * qualified classname (e.g se254.a4.t1.Counter). The User can choose a method
 * and execute that method by typing in method name on the created object.
 * 
 * Example: T1Main se254.a4.t1.Counter
 *
 * 
 * @author Author Name: Cheng-Zhen Yang Author UPI: cyan562
 * @version Date: 29/10/2020
 */

public class T1Main {
    private static Reflector reflector;
    private static Scanner scan = new Scanner(System.in);

    /**
     * Entry point of T1Main that ask for classname to analysis and print class's
     * public fields and public methods without params. Loop to ask for which method
     * the user wants to execute.
     * 
     * @param args
     */
    public static void main(String[] args) {
        String classname;

        if (args.length > 0) {
            classname = args[0];
        }

        while (true) {
            System.out.print("\nEnter a fully qualified class name: ");
            classname = getInput();

            try {
                reflector = new Reflector(classname);
                break;
            } catch (Exception e) {
                System.out.printf("\nNo such fully qualified classname: %s (ctrl-c to quit)\n", classname);
            }
        }

        System.out.printf("\nAn object has been created for %s\n", classname);

        while (true) {
            System.out.println("\nPublic fields:");
            printList(reflector.getPublicField());

            System.out.println("\nPublic methods:");
            printList(reflector.getPublicMethod());

            while (true) {
                System.out.print("\nEnter the name of a method to execute: ");
                String methodName = getInput();
                try {
                    reflector.executeMethod(methodName.replace("()", ""));
                    break;
                } catch (Exception e) {
                    System.out.printf("\nNo such method: %s (ctrl-c to quit)\n", methodName);
                }
            }
        }
    }

    /**
     * Used to get user input using scanner.
     * 
     * @return input
     */
    private static String getInput() {
        try {
            String s = scan.next();
            return s.trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Used to print ArrayList<String> to readable form by printing on each new line
     * with a indentation.
     * 
     * @param list
     */
    private static void printList(List<String> list) {
        for (String line : list) {
            System.out.println("  " + line);
        }
    }
}

package se254.a4.t1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * SE254 Assignment 4 Task 1 Main - Instructions
 * 
 * This class should be implemented to accept the user input through args[] and
 * delegate the reflection functionality to class Reflector.
 * 
 * You may implement additional classes if you wish, but this class should be
 * the main program entry point.
 * 
 * You must STAGE, COMMIT and PUSH your changes everytime you are "done" (see
 * the "definition of done" in Agile/Scrum/XP) with writing/changing this class,
 * i.e. after successfully completing Task 1, Task 2 and Task 3, respectively
 * You may COMMIT and PUSH prematurely too i.e. before each task is completed,
 * but you "must" COMMIT and PUSH to the remote repo after finishing each of the
 * A4 tasks.
 * 
 * @author Author Name: Cheng-Zhen Yang Author UPI: cyan562
 * @version Date: 29/10/2020
 */

public class T1Main {
	private static Reflector reflector;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String classname;

        if (args.length == 1) {
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
                System.out.print("\nEnter the name of a method to execute:");
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

    private static String getInput() {
        try {
            String s = scan.next();
            return s.trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    private static void printList(List<String> list) {
        for (String line : list) {
            System.out.println("  " + line);
        }
    }
}

import models.User;
import utils.BinarySearchUtil;
import utils.DeleteUtil;
import utils.InsertUtil;
import utils.QuickSortUtil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the main class of the Phone Directory Management System.
 * It contains the main method and the main program loop.
 * The main program loop displays the main screen, reads user input, and performs corresponding actions based on the input.
 * The loop continues until the user chooses to exit the program.
 */
public class Main {

    private static final ArrayList<User> userArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        program();
    }

    /**
     * The main program loop.
     * Displays the main screen, reads user input, and performs corresponding actions based on the input.
     * The loop continues until the user chooses to exit the program.
     */
    private static void program() {
        byte answer;
        loop:
        while (true) {
            printMainScreen();

            answer = scanner.nextByte();
            switch (answer) {
                case 1 -> {
                    System.out.println("\nInsert new records:");
                    insertUser();
                }
                case 2 -> {
                    System.out.println("\nDelete records:");
                    delete();
                }
                case 3 -> {
                    System.out.println("\nSearch a record by name:");
                    searchBinary();
                }
                case 4 -> {
                    System.out.println("\nDisplay records in sorted order:");
                    displayListOfRecordings();
                }
                case 5 -> {
                    printSmileFace();
                    System.err.println("Good bye");
                    break loop;
                }
                default -> System.out.println("\nUnknown Option Selected!");
            }
        }
    }


    
    /**
     * Inserts a new user into the phone directory management system.
     * Prompts the user to enter the details of the new user and adds the user to the userArrayList.
     * Prints a smiley face and a success message after adding the user.
     */
    private static void insertUser() {
        User user = InsertUtil.defineUserDetails(userArrayList);
        InsertUtil.insertNewRecord(user, userArrayList);
        printSmileFace();
        System.out.println("User successfully added");
    }



    /**
     * Deletes a user from the phone directory.
     * If the userArrayList is empty, it prints "There is no data...".
     * Otherwise, it calls the DeleteUtil.delete() method to delete the user.
     */
    private static void delete() {
        if (userArrayList.isEmpty()) {
            System.out.println("There is no data...");
        } else {
            DeleteUtil.delete(userArrayList);

        }
    }


    
    /**
     * Searches for a user in the phone directory using binary search algorithm.
     * If the user is found, their information is printed.
     * If the phone directory is empty, a message is displayed.
     * If the user is not found, a message is displayed.
     */
    private static void searchBinary() {
        if (userArrayList.isEmpty()) {
            System.out.println("There is no data...");
        } else {
            User user = BinarySearchUtil.findUserBinary(userArrayList, scanner.next());
            if (user == null) {
                System.out.println("There is no such user");
            } else {
                System.out.println(user.toString());
            }
        }
    }


    /**
     * Displays the list of users in the phone directory in alphabetic order.
     * If the phone directory is empty, a message is displayed.
     * Otherwise, the list of users is sorted using quick sort algorithm and printed.
     */
    private static void displayListOfRecordings() {
        int counter = 1;
        if (!userArrayList.isEmpty()) {
            QuickSortUtil.quickSort(userArrayList, 0, userArrayList.size() - 1);
            for (User user : userArrayList) {
                System.out.println(counter + ".");
                System.out.println(user.toString());
                counter++;
            }
        } else {
            System.out.println("There is no data...");
        }
    }

    /**
     * Prints the main screen of the phone directory management system.
     */
    private static void printMainScreen() {

        System.out.println("""

                ******* Phone Directory Management System *******
                      [1]Insert new records
                      [2]Delete existing records
                      [3]Search a record by name
                      [4]Display records in Alphabetic order
                      [5]Quit the system""");

        System.out.print("\nWhat would you like to do? ");
    }
    
    /**
     * Prints a smiley face.
     */
    private static void printSmileFace() {
        System.out.println(" +\"\"\"\"\"+ ");
        System.out.println("[| o o |]");
        System.out.println(" |  ^  | ");
        System.out.println(" | '-' | ");
        System.out.println(" +-----+ ");
    }

}



import models.User;
import utils.BinarySearchUtil;
import utils.DeleteUtil;
import utils.InsertUtil;
import utils.QuickSortUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<User> userArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        program();
    }

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

    //Module 1 STARTS
    private static void insertUser() {
        User user = InsertUtil.defineUserDetails(userArrayList);
        InsertUtil.insertNewRecord(user, userArrayList);
        printSmileFace();
        System.out.println("User successfully added");
    }
    //Module 1 ENDS


    //Module 2 STARTS
    private static void delete() {
        if (userArrayList.isEmpty()) {
            System.out.println("There is no data...");
        } else {
            DeleteUtil.delete(userArrayList);
            printSmileFace();
            System.err.println("User successfully deleted");
        }
    }
    //Module 2 ENDS

    //Module 3 STARTS
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
    //Module 3 ENDS

    //Module 4 STARTS
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
    //Module 4 ENDS

    //Screen
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

    private static void printSmileFace() {
        System.out.println(" +\"\"\"\"\"+ ");
        System.out.println("[| o o |]");
        System.out.println(" |  ^  | ");
        System.out.println(" | '-' | ");
        System.out.println(" +-----+ ");
    }

}



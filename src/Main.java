import models.User;
import utils.QuickSortUtil;
import utils.UserUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String name;
    static String number;
    private static ArrayList<User> userArrayList = new ArrayList<>();

    public static void main(String[] args) {
        program();
    }

    private static void printMainScreen() {

        System.out.println("\n******* Phone Directory Management System *******\n" +
                "      1.Insert new records\n" +
                "      2.Delete existing records\n" +
                "      3.Search a record\n" +
                "      4.Display records in Alphabetic order\n" +
                "      5.Quit the system");

        System.out.print("\nWhat would you like to do? ");
    }

    private static void program() {
        Scanner scanner = new Scanner(System.in);
        int answer;

        loop:
        while (true) {
            printMainScreen();
            answer = scanner.nextByte();

            switch (answer) {
                case 1:
                    System.out.println("\nInsert new records:");
                    insertNewRecord(defineUserDetails(scanner));
                    break;
                case 2:
                    System.out.println("\nDelete records:");
                    deleteItemRecord(scanner);
                    break;
                case 3:
                    System.out.println("\nSearch a record:");
                    search(scanner);
                    break;
                case 4:
                    System.out.println("\nDisplay records in sorted order:");
                    displayListOfRecordings();
                    break;
                case 5:
                    break loop;
                default:
                    System.out.println("\nUnknown Option Selected!");
                    break;
            }
        }
    }

    //Module 1 STARTS

    private static User defineUserDetails(Scanner scanner) {


        User user = new User();
        setUserName(user,scanner);

        System.out.print("Address: ");
        user.setAddress(scanner.next());

        setUserNumber(user,scanner);
        return user;
    }

    private static void setUserName(User user, Scanner scanner){
        System.out.print("Name (should be unique): ");
        name = scanner.next();
        if(findByName(name) == null || userArrayList.isEmpty()){
            user.setName(name);
        }
        else {
            System.out.println("Error, such name already exists");


            setUserName(user,scanner);
        }
    }

    private static void setUserNumber(User user, Scanner scanner){
        System.out.print("Number (should be unique): ");
        number = scanner.next();
        if(findByNumber(number) == null || userArrayList.isEmpty()){
            user.setPhoneNumber(number);
        }
        else {
            System.out.println("Error, such name already exists");
            setUserNumber(user,scanner);
        }
    }



    private static void insertNewRecord(User user) {
        userArrayList.add(user);
    }
    //Module 1 ENDS

    //Module 2 STARTS
    private static void deleteExistingRecord(User user) {
        userArrayList.remove(user);
    }

    private static void deleteItemRecord(Scanner scanner) {

        User user;
        System.out.println("\n******* DELETE RECORD *******\n" +
                "      1.Delete by number\n" +
                "      2.Delete by name\n" +
                "      3.<-- BACK");

        byte answer = scanner.nextByte();

        switch (answer) {
            case 1:
                System.out.println("\nNumber:");
                user = findByNumber(scanner.next());
                if (user != null) {
                    deleteExistingRecord(user);
                } else {
                    System.out.println("There is no such user with given number");
                }
                break;
            case 2:
                System.out.println("\nName:");
                user = findByName(scanner.next());
                if (user != null) {
                    deleteExistingRecord(user);
                } else {
                    System.out.println("There is no such user with given name");
                }
                break;
            case 3:
                break;
            default:
                System.out.println("\nUnknown Option Selected!");
                break;
        }
    }


    //Module 2 ENDS

    //Model 3

    private static void search(Scanner scanner) {

        User user;
        System.out.println("\n******* SEARCH RECORD *******\n" +
                "      1.Search by number\n" +
                "      2.Search by name\n" +
                "      3.Search by address\n" +
                "      4.<--BACK ");

        byte answer = scanner.nextByte();

        switch (answer) {
            case 1:
                user = findByNumber(scanner.next());
                if (user != null) {
                    System.out.println(user.toString());
                } else {
                    System.out.println("There is no such user with given number");
                }
                break;
            case 2:
                user = findByName(scanner.next());
                if (user != null) {
                    System.out.println(user.toString());
                } else {
                    System.out.println("There is no such user with given name");
                }
                break;
            case 3:
                user = findByAddress(scanner.next());
                if (user != null) {
                    System.out.println(user.toString());
                } else {
                    System.out.println("There is no such user with given address");
                }
                break;
            case 4:
                break;
            default:
                System.out.println("\nUnknown Option Selected!");
                break;
        }


    }

    private static User findByNumber(String number) {
        return UserUtils.findByNumber(userArrayList, number);
    }

    private static User findByAddress(String address) {
        return UserUtils.findByAddress(userArrayList, address);
    }

    private static User findByName(String name) {
        return UserUtils.findByName(userArrayList, name);

    }


    //Model 4 STARTS
    private static void displayListOfRecordings() {

        if (!userArrayList.isEmpty()) {
            QuickSortUtil.quickSort(userArrayList, 0, userArrayList.size()-1);
            for (User user : userArrayList) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("There is no data...");
        }
    }
    //Model 4 ENDS


}



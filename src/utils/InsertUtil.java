package utils;

import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertUtil {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Represents a user in the phone directory management system.
     */
    public static User defineUserDetails(ArrayList<User> userArrayList) {
        User user = new User();
        setUserName(user,userArrayList);

        System.out.print("Address: ");
        user.setAddress(scanner.next());

        setUserNumber(user);
        return user;
    }

    /**
     * Sets the name for the given User object, ensuring it is unique within the provided ArrayList of User objects.
     * If the name already exists in the ArrayList, prompts the user to enter a different name.
     *
     * @param user          The User object for which to set the name.
     * @param userArrayList The ArrayList of User objects to check for name uniqueness.
     */
    public static void setUserName(User user, ArrayList<User> userArrayList) {
        System.out.print("Name (should be unique): ");
        String name = scanner.next();
        if (BinarySearchUtil.findUserBinary(userArrayList, name) == null || userArrayList.isEmpty()) {
            user.setName(name);
        } else {
            System.out.println("Error, such name already exists");
            setUserName(user, userArrayList);
        }
    }

    /**
     * Sets the phone number for the given user.
     * 
     * @param user the user for whom the phone number is to be set
     */
    public static void setUserNumber(User user) {
        System.out.print("Number: ");
        String number = scanner.next();
        try {
            Integer.parseInt(number);
            user.setPhoneNumber(number);
        }
        catch (Exception e){
            System.out.println("Incorrect number");
            setUserNumber(user);
        }

    }
    /**
     * Inserts a new record into the userArrayList.
     *
     * @param user           the User object to be inserted
     * @param userArrayList  the ArrayList of User objects
     */
    public static void insertNewRecord(User user, ArrayList<User> userArrayList) {
       userArrayList.add(user);
    }
}

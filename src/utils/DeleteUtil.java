package utils;

import models.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The DeleteUtil class provides a utility method for deleting a user from an ArrayList of User objects.
 */
public class DeleteUtil {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Deletes a user from the given ArrayList based on the user's name.
     *
     * @param userArrayList the ArrayList of User objects
     */
    public static void delete(ArrayList<User> userArrayList) {
        String name = scanner.next();
        User user = BinarySearchUtil.findUserBinary(userArrayList, name);
        if (user == null) {
            System.out.println("There is no such user in Database");
        } else {
            userArrayList.remove(BinarySearchUtil.binarySearch(userArrayList,name));
            System.out.println("User successfully deleted");
        }
    }
}

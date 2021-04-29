package utils;

import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertUtil {
    static Scanner scanner = new Scanner(System.in);

    public static User defineUserDetails(ArrayList<User> userArrayList) {
        User user = new User();
        setUserName(user,userArrayList);

        System.out.print("Address: ");
        user.setAddress(scanner.next());

        setUserNumber(user);
        return user;
    }

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
    public static void insertNewRecord(User user, ArrayList<User> userArrayList) {
       userArrayList.add(user);
    }
}

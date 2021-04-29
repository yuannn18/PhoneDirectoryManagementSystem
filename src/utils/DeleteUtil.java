package utils;

import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteUtil {
    static Scanner scanner = new Scanner(System.in);

    public static void delete(ArrayList<User> userArrayList) {
        User user = BinarySearchUtil.findUserBinary(userArrayList, scanner.next());
        if (user == null) {
            System.out.println("There is no such user in Database");
        } else {
            userArrayList.remove(user);

        }
    }


}

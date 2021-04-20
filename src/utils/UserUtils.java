package utils;

import models.User;

import java.util.Collection;
//Module 3, extension
//instead of searching only by name, user can find records, by number, address or by name;  
public final class UserUtils {
    public static User findByName(Collection<User> userCollection, String name) {
        return FindUtils.findByProperty(userCollection, user -> name.equals(user.getName()));
    }

    public static User findByAddress(Collection<User> userCollection, String address) {
        return FindUtils.findByProperty(userCollection, user -> address.equals(user.getAddress()));
    }

    public static User findByNumber(Collection<User> userCollection, String number) {
        return FindUtils.findByProperty(userCollection, user -> number.equals(user.getPhoneNumber()));
    }
}
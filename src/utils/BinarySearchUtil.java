package utils;

import models.User;

import java.util.ArrayList;

public class BinarySearchUtil {

    private final static int NOT_FOUND = -1;

    public static int binarySearch(ArrayList<User> userList, String searchValue) {

        int low = 0;
        int high = userList.size() - 1;


        while (low <= high) {
            int mid = low + (high - low) / 2;

            int res = searchValue.compareTo(userList.get(mid).getName());

            if (res == 0){
                return mid;
            }

            if(res > 0){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

        }
        return NOT_FOUND;
    }

    public static User findUserBinary(ArrayList<User> userArrayList, String searchValue) {
        QuickSortUtil.quickSort(userArrayList, 0, userArrayList.size() - 1);
        int pos = binarySearch(userArrayList, searchValue);
        if (pos == -1 || userArrayList.isEmpty()) {
            return null;
        } else {
            return userArrayList.get(pos);
        }
    }
}

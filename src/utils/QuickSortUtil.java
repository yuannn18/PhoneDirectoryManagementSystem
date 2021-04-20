package utils;


import models.User;

import java.util.ArrayList;

public class QuickSortUtil {

    public static ArrayList<User> quickSort(ArrayList<User> arrayList, int start, int end)
    {
        if(start<end)
        {
            int q=partition(arrayList,start,end);
            quickSort(arrayList,start,q);
            quickSort(arrayList,q+1,end);
        }

        return arrayList;
    }

    private static int partition(ArrayList<User> arrayList, int start, int end) {

        String x = arrayList.get(start).getName();
        int i = start-1 ;
        int j = end+1 ;

        while (true)
        {
            i++;
            while ( i< end && arrayList.get(i).getName().compareTo(x) < 0)
                i++;
            j--;
            while (j>start && arrayList.get(j).getName().compareTo(x) > 0)
                j--;

            if (i < j)
                swap(arrayList, i, j);
            else
                return j;
        }
    }

    private static void swap(ArrayList<User> arrayList, int i, int j)
    {
        User tempUser = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, tempUser);
    }


}

package utils;


import models.User;

import java.util.ArrayList;

public class QuickSortUtil {

    /**
     * Sorts an ArrayList of User objects using the QuickSort algorithm.
     *
     * @param arrayList the ArrayList to be sorted
     * @param start the starting index of the subarray to be sorted
     * @param end the ending index of the subarray to be sorted
     * @return the sorted ArrayList
     */
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

    /**
     * Partitions the given ArrayList of User objects based on the name attribute.
     * 
     * @param arrayList the ArrayList of User objects to be partitioned
     * @param start the starting index of the partition
     * @param end the ending index of the partition
     * @return the index of the pivot element after partitioning
     */
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

    /**
     * Swaps two elements in an ArrayList.
     *
     * @param arrayList the ArrayList in which the elements are to be swapped
     * @param i the index of the first element to be swapped
     * @param j the index of the second element to be swapped
     */
    private static void swap(ArrayList<User> arrayList, int i, int j)
    {
        User tempUser = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, tempUser);
    }


}

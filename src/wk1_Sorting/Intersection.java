package wk1_Sorting;

import java.util.Arrays;

public class Intersection {
    public static void main(String[] args) {
        /* union = distinct elem in either array
         * intersection = distinct elem in both arrays */
        int[] data1 = {2, 3, 3, 5, 5, 6, 7, 7, 8, 12};
        int[] data2 = {5, 5, 6, 8, 8, 9, 10, 10};

        /**
         * loop over and compare [i] == [j]
         * add to result[] */

        System.out.println((char) 27 + "[97;43m" + Arrays.toString(getIntersection(data1, data2)) + (char) 27 + "[0m");
    }

    private static int[] getIntersection(int[] arr1, int[] arr2) {
        // extension of merge in mergeSort
        int i = 0;
        int j = 0;
        int[] result = new int[arr1.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                result[i] = arr1[i];
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            }
        }

        return result;
    }

}

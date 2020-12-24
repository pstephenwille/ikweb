package wk1_Sorting;

import java.util.Arrays;

public class Merge2Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 8, 9};
        int[] arr2 = {2, 3, 6, 0, 0, 0};

        // Start merging from the end.
        int last1 = arr1.length - 1;
        int last2 = arr1.length - 1;
        int last = arr2.length - 1;

        while (last >= 0) {
            System.out.println(Arrays.toString(arr2));

            if (last1 < 0) {
                arr2[last] = arr2[last2];
                last--;
                last2--;
            } else if (last2 < 0) {
                arr2[last] = arr1[last1];
                last--;
                last1--;
            } else if (arr1[last1] <= arr2[last2]) {
                arr2[last] = arr2[last2];
                last--;
                last2--;
            } else {
                arr2[last] = arr1[last1];
                last--;
                last1--;
            }

        }

        System.out.println((char) 27 + "[97;43m" + Arrays.toString(arr2) + (char) 27 + "[0m");
    }

}

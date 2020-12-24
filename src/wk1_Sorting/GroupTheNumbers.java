package wk1_Sorting;

import java.util.Arrays;

public class GroupTheNumbers {
    public static void main(String[] args) {
        /**
         * group even numbers to the left, odd to the right */
        int[] data = {2, 3, 4, 6, 7, 8, 9, 6};
        System.out.println((char)27 + "[97;43m"+ Arrays.toString(groupNumbers(data)) +(char)27+"[0m");
    }

    public static int[] groupNumbers(int[] arr) {
        //odd on right, even on left
        int left = 0;
        int right = arr.length - 1;

        while (right > left) {
            boolean isEvenNumber = arr[right] % 2 == 0;
            if (isEvenNumber) {
                //move even num to left side, and unknown number to right
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                //ok to increment since we put in even num in that index
                left++;
                //on second iteration, arr[right] is the new number from left side
                // if it's also even, we keep swapping it with the left, and continue
                // evaluating the new arr[right]
            } else {
                // arr[right] was odd, which is desired, move pointer toward left
                right--;
            }
        }

        return arr;
    }
}

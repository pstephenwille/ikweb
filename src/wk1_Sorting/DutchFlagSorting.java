package wk1_Sorting;

import java.util.Arrays;

public class DutchFlagSorting {
    public static void main(String[] args) {
        // [r,g,b]
        // long range swaps
        // 3 pointers; hi, low, current
        // when swapping at end of array hi--
        // when swapping start of array low++; current++
        // when no swap, current++

        char[] balls = {
                'R',
                'R',
                'R',
                'R',
                'R',
                'B',
                'R',
                'R',};

//        char[] balls = {'R', 'B'};

        Character pivot = 'G';
        int left = 0;
        int current = 0;
        int right = balls.length - 1;

        while (current <= right) {
            Character cur = balls[current];

            if (cur.compareTo(pivot) > 0) {
                //move 'r' to left
               swap(balls, current, left);
                left++;
                current++;
            } else if (cur.compareTo(pivot) < 0) {
                //move 'b' to right
                swap(balls, current, right);
                right--;
            }
            else if (cur.compareTo(pivot) == 0) {
                current++;
            }
        }


        System.out.println((char) 27 + "[97;43m" + Arrays.toString(balls) + (char) 27 + "[0m");
    }

    static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}

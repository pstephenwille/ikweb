package wk2_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleToAchieveTargetSum {
    public static void main(String[] args) {
        long[] arr = {60L, 50L};
        long k = 0L;

        boolean answer = check_if_sum_possible(arr, k);

        System.out.println((char) 27 + "[97;43m" + answer + (char) 27 + "[0m");
    }

    static long target;
    static long[] sum = new long[1];
    static int counter = 0;
    static List<Long> list = new ArrayList<>();

    static boolean check_if_sum_possible(long[] arr, long k) {
        target = k;
        sum = new long[1];

        if (arr.length == 1 && arr[0] == k) {
            return true;
        }


        getSum(target, arr, counter);

        return list.size() > 0 && list.get(0) == 0;
    }

    static void getSum(long target, long[] nums, int counter) {
        if (target == 0 && counter > 0) {
            list.add(sum[0]);
            return;
        }
        if (nums.length == 0) {
            return;
        }


        getSum(target - nums[0], Arrays.copyOfRange(nums, 1, nums.length), counter + 1);
        getSum(target, Arrays.copyOfRange(nums, 1, nums.length), counter);
    }


}

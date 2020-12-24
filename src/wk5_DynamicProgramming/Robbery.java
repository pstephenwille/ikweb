package wk5_DynamicProgramming;

import java.util.Arrays;

public class Robbery {
    public static void main(String[] args) {
        int[] values = {6, 1, 6, 1, 1, 10, 1, 8, 3, 2, 7, 3};// 37

//        int answer = maxStolenValue(values);
//        System.out.println((char) 27 + "[97;43m" + answer + (char) 27 + "[0m");

        int answerDP = maxStolenValueDP(values);
        System.out.println((char) 27 + "[97;43m" + answerDP + (char) 27 + "[0m");

    }


    static int maxStolenValueDP(int[] values) {
        int[] dpTable = new int[values.length];
        dpTable[0] = values[0];

        for (int i = 1; i < dpTable.length; i++) {

            if (i - 2 >= 0) {
                dpTable[i] = Math.max(
                        values[i] + dpTable[i - 2],
                        dpTable[i - 1]);
            } else
                dpTable[i] = Math.max(
                        values[i],
                        dpTable[i - 1]);

        }

        return dpTable[values.length - 1];
    }

    static int[] memo;

    public static int maxStolenValue(int[] values) {
        memo = new int[values.length];
        Arrays.fill(memo, -1);
        return maxStolenTill(values.length - 1, values);
    }

    private static int maxStolenTill(int index, int[] values) {
        if (index < 0) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        if (index == 0) {
            return memo[index] = values[0];
        }
        if (index == 1) {
            return memo[index] = Math.max(values[0], values[1]);
        }
        return memo[index] = Math.max(
                maxStolenTill(index - 2, values) + values[index],
                maxStolenTill(index - 1, values)
        );
    }
}



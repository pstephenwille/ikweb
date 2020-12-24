package wk5_DynamicProgramming;

public class CountWaysNthStair {
    public static void main(String[] args) {
        int[] steps = {1, 2};
        int n = 3;

        System.out.println((char) 27 + "[97;43m" + countWaysToClimb(steps, n) + (char) 27 + "[0m");
    }

    /*
     * Space Complexity: O(n)
     * Time Complexity: O(n*(length(steps))
     */
    private static long countWaysToClimb(int[] steps, int n) {
        long dpCache[] = new long[n + 1];

        dpCache[0] = 1;//one way to reach step 0

        for (int i = 1; i <= n; i++) {
            // Find the ways that you can reach here from current step
            for (int step : steps) {
                int previousStep = i - step;//n-step
                if (previousStep >= 0) {
                    dpCache[i] += dpCache[previousStep];
                }
            }
        }

        // Ways to reach the nth step
        return dpCache[n];
    }

    static int climbStairsSlow(int[] steps, int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        int result = 0;

        for (int step : steps) {
            result += climbStairsSlow(steps, n - step);
        }
        return result;
    }

}

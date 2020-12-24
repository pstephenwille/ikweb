package wk2_Recursion;

// catalan number series
public class HowManyBSTs {
    public static void main(String[] args) {

        int n = 5;
        long result = how_many_BSTs(n);

        System.out.println((char) 27 + "[97;43m" + result + (char) 27 + "[0m");
    }

static int count;

    static long how_many_BSTs(int n) {
        if (n == 0) {
            return 1L;
        }

        long BSTs = 0L;

        for (int left = 0; left < n; left++) {//O(n)
            int right = n - 1 - left;
            BSTs += how_many_BSTs(left) * how_many_BSTs(right);//O(n) * O(n) = O(n^2)
        }
        return BSTs;
    }
}

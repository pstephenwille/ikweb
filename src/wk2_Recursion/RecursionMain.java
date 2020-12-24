package wk2_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecursionMain {
    /**
     * position 1 = 4x,
     * position 2 = 3x,
     * position 3 = 2x,
     * position 4 = 1x
     * a,b,c,d
     * a,b,d,c
     * a,c,d,b
     * a,c,b,d
     * a,d,b,c
     * a,d,c,b
     * <p>
     * b,c,d,a
     * b,c,a,d
     * b,d,c,a
     * b,d,a,c
     * b,a,d,c
     * b,a,c,d
     * <p>
     * ...
     * ...
     * <p>
     * 24 combinations or 4! = 24
     */

    /**
     * 6 students, 4 chairs - 1,2,3,4,5,6 = _ _ _ _
     * 6*5*4*3=360
     */
    public static void main(String[] args) {
        String abc = "222";
        long myL = Character.getNumericValue(abc.charAt(0));

        System.out.println((char) 27 + "[97;43m" + "myl:" + myL + (char) 27 + "[0m");
//        raiseMoney(100);
//        System.out.println((char) 27 + "[97;43m" + factorial(4) + (char) 27 + "[0m");
//        System.out.println((char) 27 + "[97;43m" + raiseToPower(2, 4) + (char) 27 + "[0m");

//        System.out.println((char) 27 + "[97;43m" + "a " + addSequence(5, 1, 2) + (char) 27 + "[0m");
//        System.out.println((char) 27 + "[97;43m" + "b " + fibonacci(7) + (char) 27 + "[0m");

//        System.out.println((char) 27 + "[97;43m" + combinations(3, 2) + (char) 27 + "[0m");
        /*
         * 000
         * 001
         * 010
         * 100
         * 011
         * 101
         * 110
         * 111*/
        String res = binaryStrings("", 3);

//        String res2 = abcPermutations("", "abc");
//        System.out.println((char) 27 + "[97;43m" + res2 + (char) 27 + "[0m");
        String res3 = strPermutations("", "abc", "abc");
        System.out.println((char) 27 + "[97;43m" + "perms " + res3 + (char) 27 + "[0m");

//        String res = binaryStringsIncrementing("", 3);

        int[] arr = {1, 2, 3};
        int[] arr2 = Arrays.copyOfRange(arr, 1, arr.length);
//        String res = binaryStringsDecrementing(3, "");
//        System.out.println((char) 27 + "[97;43m" + res + (char) 27 + "[0m");

//        printAllSubsets(arr);

        System.out.println((char) 27 + "[97;43m" + "sets :" + getSets(0, 3, arr, 0) + (char) 27 + "[0m");

//        System.out.println((char) 27 + "[97;43m" + countSubsets(arr, 3, 0, 0) + (char) 27 + "[0m");
        int[] steps = {1, 2};
//        System.out.println((char) 27 + "[97;43m" + climbingStairs(2) + (char) 27 + "[0m");
//        System.out.println((char) 27 + "[97;43m" + climbingStairs2(2) + (char) 27 + "[0m");

        int[] printAllSubsets = {1, 3, 4, 9};
//        printAllSubsets(printAllSubsets);

        int[][] board = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
//        System.out.println((char) 27 + "[97;43m" + placeQueens(4, board, 0) + (char) 27 + "[0m");

        char[] haystack = {'a', 'b', 'c', 'a', 'a', 'd'};
        char[] match = {'a', 'b', '*', 'd'};
//        System.out.println((char) 27 + "[97;43m" + patternMatch(haystack, match, 0, 0) + (char) 27 + "[0m");
    }

    static int raiseMoney(int n) {
        System.out.println((char) 27 + "[97;43m" + n + (char) 27 + "[0m");
        if (n < 0) {
            return n;
        }

        raiseMoney(n - 10);
        return n;
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else
            return n * factorial(n - 1);
    }

    static int raiseToPower(int n, int k) {
        //n * n k times
        // O(k)
        if (k == 0) {
            return 1;
        } else {
            return n * raiseToPower(n, k - 1);
        }
    }

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int addSequence(int n, int b1, int b2) {
        //fibonacci
        //O(n)
        if (n == 0) {
            return b1;
        } else {
            return addSequence(n - 1, b2, b1 + b2);
        }
    }

    /* n choose k, C(n,k) */
    static int combinations(int n, int k) {
        if (n <= 1 || k == 0 || k == n) {
            return 1;
        }
        int combo = combinations(n - 1, k) + combinations(n - 1, k - 1);
        System.out.println((char) 27 + "[97;43m" + combo + (char) 27 + "[0m");
        return combo;
    }

    static void towerOfHanoi(int n, int[] src, int[] dst, int[] aux) {
        if (n == 1) {
            System.out.println((char) 27 + "[97;43m" + "move dist from src to dst" + (char) 27 + "[0m");
        } else {
            towerOfHanoi(n - 1, src, aux, dst);
            System.out.println((char) 27 + "[97;43m" + "move disk from src to dst" + (char) 27 + "[0m");
            towerOfHanoi(n - 1, aux, dst, src);
        }
    }


    /* permutations */
    static String binaryStrings(String res, int n) {
        if (n == 0) {
            return res;
        } else {
            String answer1 = binaryStrings(res + "0", n - 1);
            String answer2 = binaryStrings(res + "1", n - 1);
            return answer1 + "," + answer2;
        }
    }

    static String binaryStringsIncrementing(String res, int n) {
        if (n == 0) {
            return res;
        } else {
            return binaryStringsIncrementing(res + "0", n - 1) + "," + binaryStringsIncrementing(res + "1", n - 1);
        }
    }

    static String binaryStringsDecrementing(int n, String res) {
        if (n == 0) {
            return res;
        } else {
            return binaryStringsDecrementing(n - 1, res + "0") + "," + binaryStringsDecrementing(n - 1, res + "1");
        }
    }

    static String abcPermutations(String res, String str) {
        if (str.length() == 0) {
            return res;
        } else {
            String a = abcPermutations(res + "a", str.substring(0, str.length() - 1));
            String b = abcPermutations(res + "b", str.substring(0, str.length() - 1));
            String c = abcPermutations(res + "c", str.substring(0, str.length() - 1));
            return a + "," + b + "," + c;
        }
    }

    static String strPermutations(String res, String str, String refStr) {
        if (str.length() == 0) {
            return res;
        } else {
            List<String> list = new ArrayList<>();
            String builder = "";
            for (String s : refStr.split("")) {
                builder = strPermutations(res + s, str.substring(0, str.length() - 1), refStr);
                list.add(builder);
            }

            builder = list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));

            return builder;
        }
    }

    static String printPermutations(String start, int n) {

        return "";
    }


    /* sets */
    static void printAllSubsets(int[] arr) {
        List<String> sets = new ArrayList<>();
        subsetHelper("", arr, sets);

        System.out.println((char) 27 + "[97;43m" + Arrays.toString(sets.toArray()) + (char) 27 + "[0m");
    }

    static void subsetHelper(String slate, int[] arr, List<String> sets) {
        if (arr.length == 0) {
//            String[] nums = slate.split("");
//            int sum = 0;
//            for (String n : nums) {
//                if (n != "") {
//                    sum += Integer.parseInt(n);
//                }
//            }

            sets.add(slate);
        } else {
            //include
            subsetHelper(slate + arr[0], Arrays.copyOfRange(arr, 1, arr.length), sets);
            //exclude
            subsetHelper(slate, Arrays.copyOfRange(arr, 1, arr.length), sets);
        }
    }

    static int getSets(int sum, int target, int[] input, int i) {
        if (sum == target) return 1;
        else if (i == input.length - 1) return 0;
        else if (sum > target) return 0;
        else {
            getSets(sum += input[i], target, input, i++);
            getSets(sum, target, input, i++);
        }
        return sum;
    }

    static int countSubsets(int[] input, int target, int sum, int i) {
        if (sum == target) {
            return 1;
        }
        if (i == input.length || sum > target) {
            return 0;
        }

        return countSubsets(input, target, sum += input[i], i += 1) + countSubsets(input, target, sum, i += 1);
    }


    /* permutations */
    static void stringPerm(Character[] strings, Character[] result, Character str, int i) {
        /* [a1b2,a1B2, A1b2, A1B2]
         * tree
         * big case, nothing
         * base case result == strings.length || char[i] == ""
         * */
        if (result.length == i) {
            return;
        }
        if (str == null) {
            return;
        }
        Character ltr = strings[i];
        Character upperLtr = Character.toUpperCase(ltr);

        stringPerm(strings, result, str, i);
        stringPerm(strings, result, str, i);
    }


    static int climbingStairs(int numOfStairs) {
        /* f(n-steps[i]
         * n==0 return 1
         * n<0 return 0
         * */
        int[] steps = {1, 2};
        if (numOfStairs == 0) {
            return 1;
        }
        if (numOfStairs < 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < steps.length; i++) {
            result += climbingStairs(numOfStairs - steps[i]);
        }
        return result;

        /*
        steps[0] == 1; numOfStars = 3-1 = 2
        steps[1] == 2; numOfStars = 3-2 = 1
        result = 3;
        * */
    }

    static int climbingStairs2(int numOfStairs) {
        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(1);

        while (fibs.size() <= numOfStairs) {
            int newFib = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2);
            fibs.add(newFib);
        }

        return fibs.get(fibs.size() - 1);
    }


    /* Queens on chessboard */
    static int[][] placeQueens(int n, int[][] board, int i) {
        if (i == n) {
            return board;
        }

        for (int j = 0; j < n; j++) {
            if (!haConflict(board, i, j)) {
                board[i][j] = 1;
                placeQueens(n, board, i + 1);
            }
        }
        return board;
    }

    static boolean haConflict(int[][] board, int i, int j) {
        return board[i][j] == 1;
    }

    /* regex */
    static boolean patternMatch(char[] haystack, char[] match, int i, int j) {
        /* [abcaad]
         * /ab*d/
         * */
        if (j == match.length) {
            return i == haystack.length - 1;
        }
        if (i == haystack.length) {
            //process rest of math
            j++;
        }

        if (haystack[i] == match[j]) {
            return patternMatch(haystack, match, i + 1, j + 1);
        } else if (match[j] == '*') {
            return patternMatch(haystack, match, i, j + 1);
        } else {
            return false;
        }

    }

    /* Levenshtein algo; insert, delete, replace
     *   ball -> car
     *   insert; i, j++, +1
     *   delete; i--, j, + 1
     *   replace; i--, j--, +cost
     *   return min(insert, delete, replace, cost)
     * */
    static void convertS1toS2() {

    }
}

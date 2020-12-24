package wk2_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class AllCombosForTarget {
    static String str = "1234";
    static long target = 11;

    public static void main(String[] args) {
        /**
         * uses partial sum, and permutations
         * in: "1234"
         * out:["1+2*3+4"] */

        String[] answer = generate_all_expressions(str, target);
        System.out.println((char) 27 + "[97;43m" + Arrays.toString(resultList.toArray()) + (char) 27 + "[0m");

        HashSet<String> set = new HashSet<>();
//        printStrCombo(s, 0, set);

    }

    static void printStrCombo(String str, int pos, HashSet<String> set) {
        if (pos == str.length()) {
            return;
        }

        for (int i = pos; i < str.length(); i++) {
            String sub = str.substring(pos, i + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                System.out.println((char) 27 + "[97;43m" + str.substring(pos, i + 1) + (char) 27 + "[0m");

                printStrCombo(str, pos + 1, set);
            }
        }
    }

    static String[] generate_all_expressions(String str, long target) {
        List<String> retList = new ArrayList<>();
        if (str == null || str.isEmpty())
            return retList.toArray(new String[0]);
        //
        possibleExpr(0, "", 0, 0);
        return retList.toArray(new String[retList.size()]);

    }

    static List<String> resultList = new ArrayList<>();

    static void possibleExpr(int pos, String path, long curr, long prev) {

        // base case
        if (pos == str.length()) {
            if (curr == target) {
                resultList.add(path);
            }
            return;
        }
        for (int i = pos; i < str.length(); i++) {
            String strNum = str.substring(pos, i + 1);
            long num = Long.parseLong(strNum);

            if (pos == 0) {
                possibleExpr(
                        i + 1,
                        strNum,
                        num,
                        num);
            } else {
                possibleExpr(
                        i + 1,
                        path + "+" + strNum,
                        curr + num,
                        num);

                possibleExpr(
                        i + 1,
                        path + "*" + strNum,
                        (curr - prev) + (prev * num),
                        prev * num);

                System.out.println((char) 27 + "[97;43m" + +(char) 27 + "[0m");
            }
        }
    }

}

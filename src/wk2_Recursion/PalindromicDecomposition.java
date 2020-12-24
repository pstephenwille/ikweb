package wk2_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicDecomposition {
    public static void main(String[] args) {
        /**
         * in: abracadabra
         *
         * out:
         * a|b|r|a|c|ada|b|r|a
         * a|b|r|aca|d|a|b|r|a
         * a|b|r|a|c|a|d|a|b|r|a
         * */

        String s = "abracadabra";
        generate_palindromic_decompositions(s);

        System.out.println((char) 27 + "[97;43m" + Arrays.toString(list.toArray()) + (char) 27 + "[0m");

    }


    static String str;
    static List<String> list = new ArrayList<>();

    static String[] generate_palindromic_decompositions(String s) {
        str = s;
        generateString(0, "");

        return list.toArray(new String[0]);

    }

    static void generateString(int pos, String result) {
        if (pos == str.length()) {
//            System.out.println((char) 27 + "[97;43m" + result + (char) 27 + "[0m");
            list.add(result);
            return;
        }

        for (int i = pos; i < str.length(); i++) {
            String newStr = str.substring(pos, i + 1);

            if (isPalindrome(pos, i)) {
                if (pos == 0) {
                    generateString(
                            i + 1,
                            newStr);
                } else {
                    generateString(
                            i + 1,
                            result + "|" + newStr);
                }
            }
        }

    }


    static boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}

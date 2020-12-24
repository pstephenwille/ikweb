package wk2_Recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WellFormedBrackets {



    public static void main(String[] args) {
        /**
         * in: 3
         * out: ["((()))","(()())","(())()","()(())","()()()"]
         * */

        find_all_well_formed_brackets(3);

    }

    static List<String> list = new ArrayList<>();
    static int bracketLength;
    static int maxLength;
    static char[] slate;

    static String[] find_all_well_formed_brackets(int n) {
        slate = new char[2 * n];
        maxLength = n * 2;
        bracketLength = n;
        int openBracketCount = 0;
        int closeBracketCount = 0;
        int index = 0;

        buildBrackets2(openBracketCount, closeBracketCount, index);

        return list.toArray(new String[0]);
    }

    static void buildBrackets2(int openBracketCount, int closeBracketCount, int index) {
        if (index == maxLength) {
            list.add(new String(slate));
            return;
        }

        if (openBracketCount < bracketLength) {// open if can
            slate[index] = '(';
            buildBrackets2(openBracketCount + 1, closeBracketCount, index + 1);
        }

        if (closeBracketCount < openBracketCount) {// close if can
            slate[index] = ')';
            buildBrackets2(openBracketCount, closeBracketCount + 1, index + 1);
        }
    }

}

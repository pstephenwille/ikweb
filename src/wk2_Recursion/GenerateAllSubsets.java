package wk2_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllSubsets {

    public static void main(String[] args) {
        /**
         * input "xy"
         * *out ["", "x", "y", "xy"]
         */

        String s = "xy";
        String[] result = generate_all_subsets(s);

        System.out.println((char) 27 + "[97;43m" + Arrays.toString(result) + (char) 27 + "[0m");
    }

    static String str;
    static List<String> list = new ArrayList<>();

    static String[] generate_all_subsets(String s) {
        str = s;
        getSubsets("", s);

        return list.toArray(new String[0]);
    }


    static void getSubsets(String slate, String letters) {
        if (letters.length() == 0) {
            list.add(slate);

            return;
        } else {
            getSubsets(//include
                    slate + letters.charAt(0),
                    letters.substring(1));

            getSubsets(//exclude
                    slate,
                    letters.substring(1));
        }

    }
}

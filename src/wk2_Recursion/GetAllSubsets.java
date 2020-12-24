package wk2_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllSubsets {
    public static void main(String[] args) {
// answer; [x,y,xy]
        // a,b,ab,c,ac,bc,abc,
        String s = "abc";
        generate_all_subsets(s);
    }

    static String[] generate_all_subsets(String s) {
        String[] answer = new String[0];

        List<String> sets = new ArrayList<>();
        getSets("", s, sets);
        System.out.println((char) 27 + "[97;43m" + Arrays.toString(sets.toArray()) + (char) 27 + "[0m");

        return answer;
    }

    static void getSets(String answer, String s, List<String> sets) {
        String[] result = new String[0];
        /* generate all subsets
         * include/exclude
         *
         * */
        System.out.println((char)27 + "[97;43m"+ answer +(char)27+"[0m");
        if (s.length() == 0) {
            //add to set
            sets.add(answer);
        } else {
            getSets(answer + s.substring(0, 1), s.substring(1), sets);
            getSets(answer, s.substring(1), sets);
        }
    }

}

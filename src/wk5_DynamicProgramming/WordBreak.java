package wk5_DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String[] words = {"kick", "start", "kickstart", "is", "awe", "some", "awesome"};
        List<String> dictionary = Arrays.asList(words);
        String txt = "kickstartisawesome";

        int answer = Result.wordBreakCount(dictionary, txt);
        System.out.println((char)27 + "[97;43m"+ answer +(char)27+"[0m");
    }


    static class Result {

        static long MOD = (long) Math.pow(10, 9) +7L;

        public static int wordBreakCount(List<String> dictionary, String txt) {
            return 0;
        }

    }

}

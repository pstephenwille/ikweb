package wk5_DynamicProgramming;

import java.util.Arrays;

public class LevenshtienDistance {
    public static void main(String[] args) {
        String strWord1 = "batyx";
        String strWord2 = "cat";

        int answer = levenshteinDistance(strWord1, strWord2);
        System.out.println((char) 27 + "[97;43m" + answer + (char) 27 + "[0m");

    }

    static int levenshteinDistance(String strWord1, String strWord2) {
        char[] word1 = strWord1.toCharArray();
        char[] word2 = strWord2.toCharArray();
        int[][] dp = new int[word1.length + 1][word2.length + 1];

        for (int i = 0; i < word1.length + 1; i++) {
            Arrays.fill(dp[i], word1.length + word2.length);
        }
        dp[0][0] = 0;

        for (int i = 1; i < word1.length + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < word2.length + 1; i++) {
            dp[0][i] = i;
        }


        for (int ltr1 = 1; ltr1 < word1.length + 1; ltr1++) {
            for (int ltr2 = 1; ltr2 < word2.length + 1; ltr2++) {
                int current = dp[ltr1][ltr2];
                int replace = dp[ltr1 - 1][ltr2 - 1];
                int remove = dp[ltr1 - 1][ltr2];
                int insert = dp[ltr1][ltr2 - 1];

                if (word1[ltr1 - 1] == word2[ltr2 - 1]) {
                    dp[ltr1][ltr2] = Math.min(current, replace);
                } else {
                    dp[ltr1][ltr2] = Math.min(current,
                            1 + Math.min(replace,
                                    Math.min(remove, insert)
                            ));

                }
            }
        }


        return dp[word1.length][word2.length];
    }


}

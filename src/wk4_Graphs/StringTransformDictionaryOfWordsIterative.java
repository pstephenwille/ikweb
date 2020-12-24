package wk4_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class StringTransformDictionaryOfWordsIterative {

    /**
     * BFS; fifo
     * <p>
     * neighboring strings; bat, had, bad
     * visit each neighbor
     * compare chars
     * <p>
     * handle duplicate words
     * out of order chars
     */
    public static void main(String[] args) {
        String[] words = {"poon", "plee", "same", "poie", "plie", "poin"};
        String start = "toon";
        String stop = "plea";

        String[] result = string_transformation(words, start, stop);
        System.out.println((char) 27 + "[97;43m" + Arrays.toString(result) + (char) 27 + "[0m");
    }


    static int length;
    static String[] allWords;
    static List<String> result = new ArrayList<>();
    static TreeSet<String> visited = new TreeSet<>();
    static TreeSet<String> set = new TreeSet<>();
    static List<String> list = new ArrayList<>();
    private static final String[] NO_MATCH = {"-1"};
    //    static boolean[] visited;
    static String start;
    static String stop;

    static String[] string_transformation(String[] words, String s, String e) {
        start = s;
        stop = e;


        // pre conditions
        if (words.length == 0 && start.equals(stop)) return NO_MATCH;

        if (words.length == 0) return new String[]{start, stop};

        if (start.equals(stop)) {
            result.add(start);
            result.add(words[0]);
            result.add(start);

            return result.toArray(new String[0]);
        }

        // main
        allWords = new String[words.length + 1];
        for (int w = 0; w < words.length; w++) {
            allWords[w] = words[w];
        }
        allWords[allWords.length - 1] = stop;

        length = stop.length();
        result.add(start);

//        set.addAll(Arrays.asList(allWords));

//        for (String word : set) {
//            for (int i = 0; i < length; i++) {
//                if (word.charAt(i) == stop.charAt(i) && word.charAt(i) != start.charAt(i)) {
//                    char[] temp = start.toCharArray();
//                    temp[i] = word.charAt(i);
//                    start = new String(temp);
//                    result.add(start);
//                }
//            }
//        }

//        if (start.equals(stop)) {// if result, return it
//            return result.toArray(new String[0]);
//        }


//        for (int i = 0; i < length; i++) {// else get char from stop
//            if (stop.charAt(i) != start.charAt(i)) {
//                char[] temp = start.toCharArray();
//                temp[i] = stop.charAt(i);
//                start = new String(temp);
//                result.add(start);
//                break;
//            }
//        }
        int index = 0;
        set.add(allWords[index++]);
        while (!set.isEmpty()) {
            String word = set.pollFirst();
            if (!visited.contains(word)) {
                bfsWords(word, 0);
            }

            if (index < allWords.length) {
                set.add(allWords[index++]);
            }
        }

        if (result.size() > 1) {
            return result.toArray(new String[0]);
        }
        return NO_MATCH;
    }


    static void bfsWords(String word, int index) {
        if (visited.contains(word)) return;

        visited.add(word);

        for (int ii = 0; ii < length; ii++) {
            if (word.charAt(ii) == stop.charAt(ii) && word.charAt(ii) != start.charAt(ii)) {
                char[] temp = start.toCharArray();
                temp[ii] = word.charAt(ii);
                start = new String(temp);
                result.add(start);
            }
        }
    }
}

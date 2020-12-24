package wk1_Sorting;

import java.util.*;

public class LexigraphicalOrder {
    public static void main(String[] args) {
        List<String> woot = new ArrayList<>();
        woot.add("woot");
        woot.add("xxx");


        String[] ugh = woot.toArray(new String[0]);

        String[] data = {"key1 abcd", "key2 zzz", "key1 hello", "key3 world", "key1 hello"};

        System.out.println((char) 27 + "[97;43m" + Arrays.toString(lexicalSort(data)) + (char) 27 + "[0m");
    }

    private static String[] lexicalSort(String[] arr) {
        // time: O(n* max_length_keys + max_length_values)
        // space: O(n* max_length_keys + max_length_values)
        class Node {
            int count = 0;
            String hiLexVal;

            Node(String hiLexVal) {
                this.hiLexVal = hiLexVal;
            }
        }

        Map<String, Node> map = new HashMap<>();
        Map<String, Node> mapx = new HashMap<>();

        for (String s : arr) {// O(n)
            String key = s.split(" ")[0];
            String word = s.split(" ")[1];
            Node node = map.get(key);

//            mapx.computeIfAbsent(
//                    key,
//                    (k) -> new Node(word)
//            ).count++;

            mapx.compute(
                    key,
                    (k, v) -> {
                        if (v == null) {
                            v = new Node(word);
                        }
                        if (v.hiLexVal.compareTo(word) < 0) {
                            v.hiLexVal = word;

                        }
                        return v;
                    }
            ).count++;


            if (node == null) {
                map.put(key, new Node(word));
            } else {
                node.count++;
                if (word.compareTo(node.hiLexVal) > 0) {//O(w)
                    node.hiLexVal = word;
                }
            }
        }
        String[] result = new String[map.size()];

        int i = 0;
        for (String key : map.keySet()) {//O(m)
            Node node = map.get(key);//O(1)
            result[i++] = key + ":" + node.count + "," + node.hiLexVal;
        }

        return result;


    }


}

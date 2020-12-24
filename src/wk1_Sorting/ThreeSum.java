package wk1_Sorting;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
//        int[] data = {10, 3, -4, 1, -6, 9};
        Character xxx = 'x';
        int[] data = {-6, -4, 1, 3, 9, 10};
        // 6 = -4, 1, 9,
        // 5= -6,1,10
        List<Integer> input = Arrays.stream(data).boxed().collect(Collectors.toList());
        System.out.println((char) 27 + "[97;43m" + Arrays.toString(find3Sum(input)) + (char) 27 + "[0m");

//        System.out.println((char)27 + "[97;43m"+ "brute "+ Arrays.toString(find3SumBruteForce(data)) +(char)27+"[0m");
    }

    public static String[] find3Sum(List<Integer> list) {
        // time with Hashset: O(n^2 +n)
        /* time: O(n^2 + n log(n))
         * space: O(n^2) */
        HashSet<String> set = new HashSet<>();
        Map<String, Boolean> map = new HashMap<>();

        int n = list.size();
        Collections.sort(list);

        for (int i = 0; i < n; i++) {// O(n^1)
            int currentElem = list.get(i);// c
            int neededSum = -currentElem;// c
            int left = i + 1, right = n - 1;// c

            while (left < right) {// O(n^1)
                int leftNum = list.get(left);// c
                int rightNum = list.get(right);// c
                int sum = leftNum + rightNum;// c

                if (sum == neededSum) {// c
                    String key = currentElem + "," + leftNum + "," + rightNum;
                    set.add(key);// O(1)
                    map.put(key, true);
                    left++;
                }
                if (sum > neededSum) {
                    right--;
                }
//                if (sum - neededSum == 5) {
//                    System.out.println((char) 27 + "[97;43m" + "match 6 = " + currentElem + "," + leftNum + "," + rightNum + (char) 27 + "[0m");
//                }
//                if (sum - neededSum > 5) {
//                    right--;
                else {
                    left++;
                }
            }

        }

//        return set.toArray(new String[0]);
        return map.keySet().toArray(new String[0]);
    }



}

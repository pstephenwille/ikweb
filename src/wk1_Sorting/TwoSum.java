package wk1_Sorting;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        // map numbers
        // subtract number from target
        // look for difference in map
        // ...if so, end
        // set num in map

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        int[] data = {2, 7, 11, 15};
        int target = 9;

        for (int i = 0; i < data.length; i++) {
            int num = data[i];
            int compliment = target - num;

            if (map.containsKey(compliment)) {
                result.add(map.get(compliment));
                result.add(i);
                break;
            }

            map.put(num, i);
        }

        Integer[] answer = result.toArray(new Integer[0]);
        System.out.println((char)27 + "[97;43m"+ Arrays.toString(answer) +(char)27+"[0m");

    }
}

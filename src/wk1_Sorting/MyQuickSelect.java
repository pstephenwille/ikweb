package wk1_Sorting;

public class MyQuickSelect {
    public static void main(String[] args) {
        /**/
        int[] digits = {1, 6, 8, 0, 3, 5, 7, 3, 8, 4, 2};
        int k = digits.length - 1;

        System.out.println((char)27 + "[97;43m"+ quickSelect(digits, 0, digits.length -1) +(char)27+"[0m");
    }


    public static int quickSelect(int[] arr1, int low, int high) {
        if (low < high) {
            int pivotIndex = helper(arr1, low, high, arr1.length - 1);

            quickSelect(arr1, 0, pivotIndex - 1);
            quickSelect(arr1, pivotIndex + 1, high);
        }

        return arr1[arr1.length - 1];
    }


    private static int helper(int[] arr, int start, int end, int index) {
        if (start == end || start == index) {
            // also == index
            return index;
        }

        int pivot = arr[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[j];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }
}

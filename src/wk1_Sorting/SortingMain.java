package wk1_Sorting;

import java.util.Arrays;

public class SortingMain {

    public static void main(String[] args) {
        /**
         * single pass on unsorted list
         * sum, min, max, mean(avg of min/max) */
        int[] data = {11, 1, 2, 3, 4, 5, 6, 7};
        int[] data1 = {11, 1, 0, 9, 4, 9, 2};
//        System.out.println((char) 27 + "[97;43m" + "selection sort\n" + Arrays.toString(selectionSort(data)) + (char) 27 + "[0m");
//        insertionSortRecursive(data, data.length -1);
//        System.out.println((char) 27 + "[97;43m" + Arrays.toString(data) + (char) 27 + "[0m");

//        insertionSortLoop(data, data.length - 1);
//        System.out.println((char)27 + "[97;43m"+ Arrays.toString(data) +(char)27+"[0m");
//        System.out.println((char) 27 + "[97;43m" + Arrays.toString(selectionSort(data)) + (char) 27 + "[0m");

//        int[] sorted = mergeSort(data);
//        System.out.println((char) 27 + "[97;43m" + Arrays.toString(sorted) + (char) 27 + "[0m");

        quickSort(data, 0, data.length -1);
        System.out.println((char) 27 + "[97;43m" + "quick sort " + Arrays.toString(data) + (char) 27 + "[0m");


//        System.out.println((char)27 + "[97;43m"+ Arrays.toString(sortWith2Pointers(data1)) +(char)27+"[0m");
    }

    static int[] sortWith2Pointers(int[] arr) {

        int left = 0;

        for (int current = 1; current < arr.length; current++) {
            if (arr[left] > arr[current]) {
                int temp = arr[left];
                arr[left] = arr[current];
                arr[current] = temp;
                left++;
            }
        }
        return arr;
    }

    private static int[] selectionSort(int[] arr) {
        // O(n2)
        // unstable
        // good for almost sorted
        // long range swaps
        /**
         * n iterations
         * smallest = a[1...i - 1]
         * largest = a[n-i+1] -- length - i+1
         * ....10 - 5+1 = 6
         * ....10 - 6+1 = 5
         * ....10 - 7+1 = 4 */

        for (int i = 0; i < arr.length - 1; i++) {
            int nth = i;

            for (int next = i + 1; next < arr.length; next++) {
                if (arr[nth] > arr[next]) {
                    nth = next;// long range swaps; last matching largest index, putting them out of order, aka unstable
                }
            }

            int tmpSmallerNum = arr[nth];
            arr[nth] = arr[i];
            arr[i] = tmpSmallerNum;
        }
        return arr;
    }


    private static void insertionSortRecursive(int[] arr, int n) {
        // stable; short range swaps
        // good for almost sorted
        if (n <= 0) return;
        insertionSortRecursive(arr, n - 1);

        int nth = arr[n];
        int prevNth = n - 1;

        while (prevNth >= 0 && arr[prevNth] > nth) {
            //a, 5>3;[1,2,4,5,3]
            //b, 4>3; [1,2,4,5,5]
            arr[prevNth + 1] = arr[prevNth];
            //a, [1,2,4,5,5]
            //b, [1,2,4,4,5]
            prevNth--;
        }
        //after bubbling smaller nums, set nth
        //[1,2,4,5,5]
        arr[prevNth + 1] = nth;
        //[1,2,3,4,5]

        return;
    }

    public static void insertionSortLoop(int[] arr, int n) {
        if (n <= 0) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            int nth = arr[i];
            int prev = i - 1;

            while (prev >= 1 && arr[prev] > nth) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = nth;
        }
    }


    /**
     * merge sort - divide and conquer
     * 1. define helper to sort sub arrays
     * 2.
     */
    public static int[] mergeSort(int[] list) {
        // stable - if implemented with left <= right
        // no in place
        // If list is empty; no need to do anything
        if (list.length <= 1) {
            return list;
        }

        // Create 2 lists to hold 1st half and 2nd half of original list.
        int[] left = new int[list.length / 2];
        int[] right = new int[list.length - left.length];
        // Split the array in half and populate above lists.
        System.arraycopy(list, 0, left, 0, left.length);
        System.arraycopy(list, left.length, right, 0, right.length);

        // Sort each half recursively
        mergeSort(left);
        mergeSort(right);

        // Merge both halves together, overwriting original array
        merge(left, right, list);
        return list;
    }

    private static void merge(int[] left, int[] right, int[] result) {
        // Index Position in first array - starting with first element
        int iFirst = 0;

        // Index Position in second array - starting with first element
        int iSecond = 0;

        // Index Position in merged array - starting with first position
        int iMerged = 0;

        // Compare elements at iFirst and iSecond,
        // and move smaller element at iMerged
        while (iFirst < left.length && iSecond < right.length) {
            if (left[iFirst] < right[iSecond]) {
                result[iMerged] = left[iFirst];
                iFirst++;
            } else {
                // if elems are equal, add left to maintain stability
                result[iMerged] = right[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        // copy remaining elements from both halves - each half will have already sorted
        // elements
        System.arraycopy(left, iFirst, result, iMerged, left.length - iFirst);
        System.arraycopy(right, iSecond, result, iMerged, right.length - iSecond);
    }


    /**
     * quick sort - divide and conquer
     */
    public static void quickSort(int arr[], int begin, int end) {
        // unstable
        // in place
        // fastest
        if (begin < end) {
            int partitionIndex = quickSortPartition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }


    private static int quickSortPartition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }


    private static int heapSort(int arr[]) {
        // in place
        // unstable
        /**
         * 1. build a min heap of array nums; heap.heapify()
         * 2. while nums not empty
         *      extract next
         *      append to result
         * */

        return 0;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class bucketsort {
    public static void bucketSort(int[] array, int bucketCount) {
        if (array == null || array.length == 0 || bucketCount <= 0) {
            return;
        }
        int max = array[0];
        int min = array[0];
        // Find the maximum and minimum values in the array
        for (int value : array) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        // Calculate the range for each bucket
        double range = (double) (max - min + 1) / bucketCount;

        // Create empty buckets
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
  // Place each element in the appropriate bucket
        for (int value : array) {
            int bucketIndex = (int) ((value - min) / range);
            buckets.get(bucketIndex).add(value);
        }

        // Sort each bucket and place the elements back into the original array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                array[index++] = value;
            }
        }
    }
   public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11, 99, 88, 1, 90};
        int bucketCount = 5;
        System.out.println("Original Array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        bucketSort(array, bucketCount);
        System.out.println("\nSorted Array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}

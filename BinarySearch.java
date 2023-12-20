public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found, return its index.
            } else if (arr[mid] < target) {
                left = mid + 1; // Target is in the right half.
            } else {
                right = mid - 1; // Target is in the left half.
            }
        }

        return -1; // Target not found in the array.
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 10, 15, 21, 28, 34, 36, 42};
        int target = 15;

        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("The target value " + target + " is found at index " + result);
        } else {
            System.out.println("The target value " + target + " is not in the array.");
        }
    }
}

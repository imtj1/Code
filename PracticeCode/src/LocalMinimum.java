public class LocalMinimum {
    public static int findLocalMinimum(int[] arr, int low,
                                       int high) {

        int mid = (low + high) / 2;

        if ((mid == 0 || arr[mid - 1] > arr[mid]) && (mid == arr.length - 1 || arr[mid] < arr[mid + 1])) {
            return mid;
        }
        else if (arr[mid - 1] < arr[mid]) {
            return findLocalMinimum(arr, low, mid - 1);
        }

        return findLocalMinimum(arr, mid + 1, high);
    }
}

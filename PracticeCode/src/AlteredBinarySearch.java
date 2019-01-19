public class AlteredBinarySearch {
    static boolean alteredBinarySearch(int arr[], int low, int high)
    {
        if(high >= low)
        {
            int mid = (low + high)/2;
            if(mid == arr[mid])
                return true;
            if(mid > arr[mid])
                return alteredBinarySearch(arr, low, (mid -1));
            else
                return alteredBinarySearch(arr, (mid + 1), high);
        }

        return false;
    }

    //main function
    public static void main(String args[])
    {
        int arr[] = {100,50,30,11,10,5,0,-1,-10};
        int n = arr.length;
        System.out.println("Fixed Point is "
                + alteredBinarySearch(arr,0, n-1));
    }
}

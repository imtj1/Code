public class ArrayIndex {

    public static void getArrayLength(int[] arr){
        for(int i=1;;i*=2){
            if(!checkIndex(arr, i)){
                System.out.println(binarySearch(arr,i/2, i));
                break;
            }
        }
    }

    public static boolean checkIndex(int[] arr, int index){
        try{
            int a = arr[index];
            return true;
        }
        catch(ArrayIndexOutOfBoundsException a){
            return false;
        }
    }

    public static int binarySearch(int arr[], int leftIndex, int rightIndex)
    {
        while (leftIndex <= rightIndex)
        {
            int midIndex = leftIndex + (rightIndex-leftIndex)/2;

            if (checkIndex(arr, midIndex) && !checkIndex(arr, midIndex+1))
                return midIndex+1;      //adding 1 to the last index

            if (checkIndex(arr, midIndex))
                leftIndex = midIndex + 1;

            else
                rightIndex = midIndex - 1;
        }

        return -1;
    }
}

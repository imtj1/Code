import java.util.Arrays;

public class Main {
static int c = 0;
    public static void main(String[] args) {
        int[] ar ={1,4,4,4,1,9};
//        int a =LargestSumSAR.LSS(ar, 0 , ar.length-1);
//        LargestSumSubArray.LSS(ar, ar.length);
        printAllPerm(ar, 0);
//        BooksComb.countComb(4);
//        System.out.println(BooksComb.count + "dgdfg"+BooksComb.funcCount);
//          System.out.println(a+":no good::"+LargestSumSAR.noGood);
//        ArrayIndex.getArrayLength(ar);
//        System.out.println(sumOfSubset.findIfConditionExists(ar));
 /*       int j = 4;//100
        int f = 1 << j;//10000
        System.out.println(f);
*/

    }


    private static void printAllPerm(int[] ar, int startIndex){
        if(startIndex == ar.length){
            System.out.println(Arrays.toString(ar) + ++c);
            return;
        }
        for(int i=startIndex ; i < ar.length ; i++){
            swap(startIndex,i,ar);
            printAllPerm(ar, startIndex+1);
            swap(i,startIndex,ar);
        }

    }

    private static void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

public class LargestSumSubArray {
    static int LSS(int arr[], int size){
        int msf = arr[0];
        int cm = arr[0];
        for (int i=0; i< arr.length; i++)
        {
            cm = Math.max(cm + arr[i], arr[i]);
            msf = Math.max(cm, msf);
        }
        return msf;
    }
}

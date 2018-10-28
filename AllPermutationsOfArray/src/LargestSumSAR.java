

public class LargestSumSAR {
    public static boolean noGood = false;
    public static int LSS(int ar[], int s, int e){
        int m = (e+s)/2;
        if(s==e){
            return ar[s];
        }
        int LSS = LSS(ar, s, m);
        int RSS = LSS(ar, m+1, e);

        int sum =0;int leftSum = 0;int rightSum = 0;
        int csi = 0,cei = 0;
        for(int i = m;i>=s;i--){
            sum+= ar[i];
            if(sum > leftSum) {
                leftSum = sum;
                csi = i;
            }
            leftSum = Math.max(sum,leftSum);
        }
        sum =0;
        for(int j=m+1;j<=e;j++){
            sum+=ar[j];
            if(sum > rightSum) {
                rightSum = sum;
                cei = j;
            }
        }
        int maxOneSide = Math.max(LSS,RSS);
        if(LSS < (((e-s + 1)/2)^2) || RSS < (((e-s + 1)/2)^2)){
            noGood = true;
        }
        int continuoussum = leftSum+rightSum;
        if(continuoussum < (((cei - csi + 1)/2)^2)){
            noGood = true;
        }
        int totalMax = Math.max(leftSum+rightSum, maxOneSide);
        return Math.max(totalMax,maxOneSide);
    }
}

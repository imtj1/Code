import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthSmallestPair {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> listOfRes = new ArrayList<>();
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if(i+1 >= nums.length)break;
            listOfRes.add(Math.abs(nums[i] - nums[i + 1]));
            smallestDiff = Math.min(smallestDiff, Math.abs(nums[i] - nums[i + 1]));
        }
        Collections.sort(listOfRes);
        return listOfRes.get(k - 1);
    }


    public static void main(String[] args) {
        int[] arr = {1,3,1};
        smallestDistancePair(arr,1);

    }
}

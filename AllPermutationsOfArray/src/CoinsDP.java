import java.util.Arrays;

public class CoinsDP {


    public static void computeCoinsComb(int[] coins, int sum) {
        int[] count = new int[sum + 1];
        Arrays.fill(count, 0);
        count[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                count[j] += count[j - coin];
            }
        }
    }
}

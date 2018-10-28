public class BuildString {
    //aabaacaba,4 5
    static int buildString(int a, int b, String s) {
        int cost = 0;
        String buildString = "";
        int lowerIndex = 0;
        int upperIndex = 1;
        while (true) {
            if (buildString.contains(s.substring(lowerIndex, upperIndex))) {
                upperIndex++;
            } else {
                if (b + a < (upperIndex - lowerIndex) * a) {
                    cost += b;
                    buildString += s.substring(lowerIndex, upperIndex - 1);
                    lowerIndex = upperIndex - 1;
                } else {
                    cost += (upperIndex - lowerIndex) * a;
                    buildString += s.substring(lowerIndex, upperIndex);
                    upperIndex++;
                    lowerIndex = upperIndex - 1;
                }
            }
            if (upperIndex > s.length()) {
                cost += Math.min(b, (upperIndex - lowerIndex - 1) * a);
                break;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int cost = buildString(8,9, "bacbacacb");
        System.out.println(cost);
    }
}

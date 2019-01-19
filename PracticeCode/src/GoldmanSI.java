import java.util.ArrayList;
import java.util.List;

public class GoldmanSI {


    static List<String> charityAllocation(List<Float> profits) {
        Float totalForA = 0.0f;
        Float totalForB = 0.0f;
        Float totalForC = 0.0f;
        List<String> result = new ArrayList<>();

        for (Float profit : profits) {
            if (totalForA <= totalForB && totalForA <= totalForC) {
                totalForA += profit;
                result.add("A");
            } else if (totalForB <= totalForC) {
                totalForB += profit;
                result.add("B");
            } else {
                totalForC += profit;
                result.add("C");
            }
        }
        return result;
    }


    public static void main(String[] str) {
        List<Float> pr = new ArrayList<>();
        pr.add(25f);
        pr.add(8f);
        pr.add(2f);
        pr.add(35f);
        pr.add(15f);
        pr.add(120f);
        pr.add(55f);
        pr.add(42f);
        charityAllocation(pr);
    }
}

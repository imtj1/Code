import java.util.Arrays;
class Box implements Comparable<Box>{

    // h --> height, w --> width,
    // d --> depth
    int h, w, d, area;

    // for simplicity of solution,
    // always keep w <= d

    /*Constructor to initialise object*/
    public Box(int h, int w, int d) {
        this.h = h;
        this.w = w;
        this.d = d;
    }

    /*To sort the box array on the basis
    of area in decreasing order of area */
    @Override
    public int compareTo(Box o) {
        return o.area-this.area;
    }
}

public class StackOfBoxes {

    static int maxStackHeight(Box arr[], int n) {

        for (Box anArr : arr) anArr.area = anArr.w * anArr.d;

        Arrays.sort(arr); // sort in decreasing order of base area

        int[] maxHeightMemo = new int[n];
        for (int i = 0; i < n; i++)
            maxHeightMemo[i] = arr[i].h;

        for (int i = 0; i < n; i++) {
            maxHeightMemo[i] = 0;
            Box box = arr[i];
            int val = 0;

            for (int j = 0; j < i; j++) {   //for all boxes with base area less than current box, i.e. the elements of the array till i
                Box prevBox = arr[j];
                if (box.w < prevBox.w && box.d < prevBox.d) {   // chack for width and length to be lesser
                    val = Math.max(val, maxHeightMemo[j]);  //getting max value if the current box is stacked on top of every other possibility in the table
                }
            }
            maxHeightMemo[i] = val + box.h;       //assigning max
        }

        int max = -1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, maxHeightMemo[i]);  // finding max height from the array of max heights with every possible box
        }

        return max;
    }
}

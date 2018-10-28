import java.util.ArrayList;
import java.util.List;

public class SmallestSliceMatrix {
    private static void findSmallestSlice(Integer[][] n, int row) {
        if (row == n.length - 1) {
            return;
        }
        findSmallestSlice(n, row + 1);
        for (int i = 0; i < n[0].length; i++) {
            n[row][i] = findSamllCurrElem(n, row, i);
        }
    }

    private static int findSamllCurrElem(Integer[][] n, int row, int col) {
        return Math.min(Math.min(n[row][col] + value(n, row + 1, col, n[row][col]),
                n[row][col] + value(n, row + 1, col - 1,
                        n[row][col])), n[row][col] + value(n, row + 1, col + 1,
                n[row][col]));
    }

    private static int value(Integer[][] n, int row, int col, int value) {
        try {
            return n[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            return Integer.MAX_VALUE - value;
        }
    }

    private static int findSmallestSlice(Integer[][] n) {
        findSmallestSlice(n, 0);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n[0].length; i++) {
            min = Math.min(min, n[0][i]);
        }
        return min;
    }

    private static Integer[][] convertTo2dArray(List<List<Integer>> arrayList) {
        Integer[][] array = new Integer[arrayList.size()][];
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<Integer> row = (ArrayList<Integer>) arrayList.get(i);
            array[i] = row.toArray(new Integer[row.size()]);
        }
        return array;
    }

    static int MinSliceWeight(List<List<Integer>> matrix) {
        if (matrix.size() == 0 || matrix.get(0).size() == 0) {
            return 0;
        }
        return findSmallestSlice(convertTo2dArray(matrix));
    }
}



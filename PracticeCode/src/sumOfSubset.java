
public class sumOfSubset {

    static boolean findIfConditionExists(int array[]) {
        sort(array, 0, array.length - 1);
        int sum = 0;
        for (int i = 1; i <= array.length - 1; i++) {
            sum += array[i];
            if (sum < (i ^ 2)) {
                return false;
            }
        }
        return true;
    }

    static void merge(int array[], int leftIndex, int middleIndex, int rightIndex) {
        int lengthOfLeftSubArray = middleIndex - leftIndex + 1;
        int lengthOfRightSubArray = rightIndex - middleIndex;

        int leftArray[] = new int[lengthOfLeftSubArray];
        int rightArray[] = new int[lengthOfRightSubArray];

        for (int i = 0; i < lengthOfLeftSubArray; ++i)
            leftArray[i] = array[leftIndex + i];
        for (int j = 0; j < lengthOfRightSubArray; ++j)
            rightArray[j] = array[middleIndex + 1 + j];

        int leftIteratingIndex = 0, rightIteratingIndex = 0;

        int finalIndex = leftIndex;
        while (leftIteratingIndex < lengthOfLeftSubArray && rightIteratingIndex < lengthOfRightSubArray) {
            if (leftArray[leftIteratingIndex] <= rightArray[rightIteratingIndex]) {
                array[finalIndex] = leftArray[leftIteratingIndex];
                leftIteratingIndex++;
            } else {
                array[finalIndex] = rightArray[rightIteratingIndex];
                rightIteratingIndex++;
            }
            finalIndex++;
        }

        while (leftIteratingIndex < lengthOfLeftSubArray) {
            array[finalIndex] = leftArray[leftIteratingIndex];
            leftIteratingIndex++;
            finalIndex++;
        }

        while (rightIteratingIndex < lengthOfRightSubArray) {
            array[finalIndex] = rightArray[rightIteratingIndex];
            rightIteratingIndex++;
            finalIndex++;
        }
    }

    static void sort(int array[], int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            sort(array, leftIndex, middleIndex);
            sort(array, middleIndex + 1, rightIndex);

            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }
}

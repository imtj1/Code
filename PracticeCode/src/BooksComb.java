public class BooksComb {
    static int count = 0;

    static void countNumberOfCombinations(int bookShelfUnits) {
        if (bookShelfUnits == 0) {
            count++;
            return;
        }
        if (bookShelfUnits < 0) {
            return;
        }
        if (bookShelfUnits >= 3)
            countNumberOfCombinations(bookShelfUnits - 3);
        if (bookShelfUnits >= 2)
            countNumberOfCombinations(bookShelfUnits - 2);
        if (bookShelfUnits >= 1)
            countNumberOfCombinations(bookShelfUnits - 1);
        return;
    }
}

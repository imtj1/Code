public class Prog2 {

    public static void main(String[] args) {

        {

            System.out.println("\nRequirement a,b ****************** showing printing heap array");
            MaxHeapPQ maxHeapPQ1 = new MaxHeapPQ(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1});
            maxHeapPQ1.printAsArray();

            System.out.println("\nRequirement c ******************** showing max heapify");
            MaxHeapPQ maxHeapPQ2 = new MaxHeapPQ(new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1});
            maxHeapPQ2.maxHeapify(2, true);

            System.out.println("\nRequirement d ********************showing building max heap");
            MaxHeapPQ maxHeapPQ3 = new MaxHeapPQ(new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7});
            maxHeapPQ3.maxHeap(true);

            System.out.println("\nRequirement e ******************** showing heap sort");
            MaxHeapPQ maxHeapPQ4 = new MaxHeapPQ(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1});
            maxHeapPQ4.heapSort();
            maxHeapPQ4.printAsArray();

            System.out.println("\nRequirement f ******************** increasing position 7 to 17 from 4 using increase key");
            MaxHeapPQ maxHeapPQ5 = new MaxHeapPQ(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1});
            maxHeapPQ5.printAsArray();
            maxHeapPQ5.increaseKey(7, 17);
            maxHeapPQ5.printAsArray();
        }
    }
}

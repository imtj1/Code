public class MaxHeapPQ {
    private int[] Heap;
    private int size;

    private static final int FRONT = 1;

    public MaxHeapPQ(int maxsize) {
        this.size = 0;
        Heap = new int[maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    //Requirement b, constructing heap with array
    public MaxHeapPQ(int[] arr) {
        this.size = arr.length;
        Heap = new int[arr.length + 1];
        Heap[0] = Integer.MAX_VALUE;
        int i = 1;
        for (int a : arr) {
            Heap[i++] = a;
        }
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    void maxHeapify(int pos, boolean print) {
        if (print) {
            this.printAsArray();
        }
        int largest = 0;
        int l = leftChild(pos);
        int r = rightChild(pos);
        if (l <= size && Heap[l] > Heap[pos]) {
            largest = l;
        } else {
            largest = pos;
        }
        if (r <= size && Heap[r] > Heap[largest]) {
            largest = r;
        }
        if (largest != pos) {
            swap(pos, largest);
            maxHeapify(largest, print);
        }
    }

    public void insert(int element) {
        Heap[++size] = element;
        int current = size;

        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    void printAsArray() {
        for (int i = 1; i <= size; i++) {
            System.out.print(Heap[i] + " ");
        }
        System.out.print("\n");
    }

    //used to print the sorted array in the case of heap sort
    void printRestOfArray() {
        for (int i = size + 1; i < Heap.length; i++) {
            System.out.print(Heap[i] + " ");
        }
        System.out.print("\n");
    }

    void maxHeap(boolean print) {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos, print);
        }
    }

    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT, false);
        return popped;
    }

    void increaseKey(int i, int val) {
        if (val < Heap[i]) {
            return;
        }
        Heap[i] = val;
        while (i > 1 && Heap[parent(i)] < Heap[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    //used for heap sort
    void heapSort() {
        maxHeap(false);
        for (int i = size; i >= 2; i--) {
            swap(1, i);
            size--;
            maxHeapify(1, false);
            printAsArray();
            printRestOfArray();
        }
    }
}
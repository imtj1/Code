import java.util.EmptyStackException;

public class IntegerQueue {
    private int front = 0, rear, size = 0, capacity;
    private int internalArray[];

    /*Constructor with capacity as parameter*/
    public IntegerQueue(int capacity) {
        this.capacity = capacity;
        rear = capacity - 1;
        internalArray = new int[capacity];
    }

    /*enqueue to add an element into the queue*/
    public void enqueue(int item) throws Exception {
        if (isFull())
            throw new Exception("Queue is full");
        this.rear = (this.rear + 1) % this.capacity;
        this.internalArray[this.rear] = item;
        this.size++;
    }

    /*de_queue to remove elements from the function*/
    public int de_queue() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        int item = this.internalArray[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return item;
    }

    /*returns true if the queue is full and false otherwise*/
    public boolean isFull() {
        return (size == capacity);
    }

    /*return true if queue is empty and false otherwise*/
    public boolean isEmpty() {
        return (size == 0);
    }

}


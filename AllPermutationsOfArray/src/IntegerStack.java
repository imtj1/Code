import java.util.EmptyStackException;

public class IntegerStack {
    private int internalArray[];
    private int size;
    private int index = 0;

    /*Constructor with size as parameter*/
    public IntegerStack(int size) {
        this.size = size;
        internalArray = new int[size];
    }

    /*Push function to add elements to the stack*/
    public void push(int element) {

        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }

        internalArray[index] = element;
        index++;
    }

    /*Pop function to remove elements from the stack
    * Returns the popped element from the stack*/
    public int pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return internalArray[--index];
    }

    /*Returns true if stack is empty and false otherwise*/
    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }

    /*Returns true if stack is full and empty otherwise*/
    public boolean isFull() {
        if (index == size - 1) {
            return true;
        }
        return false;
    }
}

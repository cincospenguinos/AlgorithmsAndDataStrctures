package usa.cincospenguinos.main.structures.stack;

public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_STARTING_SIZE = 8;

    private T[] backingStore;
    private int currentIndex;

    public ArrayStack() {
        backingStore = (T[]) new Object[DEFAULT_STARTING_SIZE];
        currentIndex = 0;
    }

    public ArrayStack(int size) {
        backingStore = (T[]) new Object[size];
        currentIndex = 0;
    }

    public void push(T item) {
        if (isFull()) {
            growStore();
        }

        backingStore[currentIndex] = (T) item;
        currentIndex += 1;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return backingStore[currentIndex - 1];
    }

    private boolean isFull() {
        return currentIndex == backingStore.length;
    }

    private void growStore() {
        int newSize = (backingStore.length * 2) + 1;
        T[] newStore = (T[]) new Object[newSize];

        for (int i = 0; i < backingStore.length; i++) {
            newStore[i] = backingStore[i];
        }

        backingStore = newStore;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        currentIndex -= 1;
        return backingStore[currentIndex];
    }

    @Override
    public void clear() {
        currentIndex = 0;
    }

    public boolean isEmpty() {
        return currentIndex == 0;
    }
}

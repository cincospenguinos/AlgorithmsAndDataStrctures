package usa.cincospenguinos.main.structures.queue;

public class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_STARTING_SIZE = 8;
    private T[] backingStore;
    private int insertionIndex;
    private int removalIndex;
    private int size;

    public ArrayQueue() {
        backingStore = (T[]) new Object[DEFAULT_STARTING_SIZE];
        insertionIndex = 0;
        removalIndex = 0;
        size = 0;
    }

    public ArrayQueue(int startingArraySize) {
        backingStore = (T[]) new Object[startingArraySize];
        insertionIndex = 0;
        removalIndex = 0;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (isFull()) {
            grow();
        }

        if (mustRolloverIndexes()) {
            insertionIndex = 0;
        }

        backingStore[insertionIndex] = item;
        insertionIndex += 1;
        size += 1;
    }

    private boolean isFull() {
        return size == backingStore.length;
    }

    private void grow() {
        int newSize = backingStore.length * 2;
        T[] newStore = (T[]) new Object[newSize];

        for (int i = 0; i < backingStore.length; i++) {
            int nextInQueue = (i + removalIndex) % backingStore.length;
            newStore[i] = backingStore[nextInQueue];
        }

        insertionIndex = backingStore.length;
        backingStore = newStore;
        removalIndex = 0;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        if (mustRolloverIndexes()) {
            removalIndex = 0;
        }

        T item = backingStore[removalIndex];
        removalIndex += 1;
        size -= 1;

        return item;
    }

    private boolean mustRolloverIndexes() {
        return removalIndex == backingStore.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

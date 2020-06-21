package usa.cincospenguinos.main.structures.queue;

import usa.cincospenguinos.main.structures.DynamicArray;

public class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_STARTING_SIZE = 8;

    private DynamicArray<T> backingStore;
    private int insertionIndex;
    private int removalIndex;
    private int size;

    public ArrayQueue() {
        backingStore = new DynamicArray<>(DEFAULT_STARTING_SIZE);
        insertionIndex = 0;
        removalIndex = 0;
        size = 0;
    }

    public ArrayQueue(int startingArraySize) {
        backingStore = new DynamicArray<>(startingArraySize);
        insertionIndex = 0;
        removalIndex = 0;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (isFull()) {
            backingStore.grow();
        }

        if (mustRolloverIndexes()) {
            insertionIndex = 0;
        }

        backingStore.insertAt(item, insertionIndex);
        insertionIndex += 1;
        size += 1;
    }

    private boolean isFull() {
        return size == backingStore.length();
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        if (mustRolloverIndexes()) {
            removalIndex = 0;
        }

        T item = backingStore.removeAt(removalIndex);
        removalIndex += 1;
        size -= 1;

        return item;
    }

    private boolean mustRolloverIndexes() {
        return removalIndex == backingStore.length();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

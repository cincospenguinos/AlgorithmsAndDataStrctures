package usa.cincospenguinos.main.structures.stack;

import usa.cincospenguinos.main.structures.DynamicArray;

public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_STARTING_SIZE = 8;

    private DynamicArray<T> backingArray;
    private int currentIndex;

    public ArrayStack() {
        backingArray = new DynamicArray<>(DEFAULT_STARTING_SIZE);
        currentIndex = 0;
    }

    public ArrayStack(int size) {
        backingArray = new DynamicArray<>(size);
        currentIndex = 0;
    }

    public void push(T item) {
        if (isFull()) {
            backingArray.grow();
        }

        backingArray.insert(item, currentIndex);
        currentIndex += 1;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return backingArray.get(currentIndex - 1);
    }

    private boolean isFull() {
        return currentIndex == backingArray.length();
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        currentIndex -= 1;
        return backingArray.remove(currentIndex);
    }

    @Override
    public void clear() {
        currentIndex = 0;
        backingArray = new DynamicArray<>(backingArray.length());
    }

    public boolean isEmpty() {
        return currentIndex == 0;
    }
}

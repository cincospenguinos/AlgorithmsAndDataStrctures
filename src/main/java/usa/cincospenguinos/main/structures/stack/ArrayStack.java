package usa.cincospenguinos.main.structures.stack;

import usa.cincospenguinos.main.structures.arrays.SimpleDynamicArray;

public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_STARTING_SIZE = 8;

    private SimpleDynamicArray<T> backingArray;
    private int currentIndex;

    public ArrayStack() {
        backingArray = new SimpleDynamicArray<>(DEFAULT_STARTING_SIZE);
        currentIndex = 0;
    }

    public ArrayStack(int size) {
        backingArray = new SimpleDynamicArray<>(size);
        currentIndex = 0;
    }

    public void push(T item) {
        if (isFull()) {
            backingArray.grow();
        }

        backingArray.set(item, currentIndex);
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
        backingArray = new SimpleDynamicArray<>(backingArray.length());
    }

    public boolean isEmpty() {
        return currentIndex == 0;
    }
}

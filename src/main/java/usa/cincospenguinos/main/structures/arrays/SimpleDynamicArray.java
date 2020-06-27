package usa.cincospenguinos.main.structures.arrays;

/**
 * Abstraction of a self-growing array. For use to ensure DRYing up pieces of this codebase, but
 * exposed as a valid data structure as well. Intended to be as close to an array as possible.
 */
public class SimpleDynamicArray<T> implements DynamicArray<T> {
    private static final int DEFAULT_STARTING_SIZE = 8;

    private T[] backingArray;

    public SimpleDynamicArray() {
        backingArray = (T[]) new Object[DEFAULT_STARTING_SIZE];
    }

    public SimpleDynamicArray(int startingSize) {
        backingArray = (T[]) new Object[startingSize];
    }

    public void set(T item, int index) {
        backingArray[index] = item;
    }

    public T get(int index) {
        return backingArray[index];
    }

    public T remove(int index) {
        T item = backingArray[index];
        backingArray[index] = null;
        return item;
    }

    public int length() {
        return backingArray.length;
    }

    public void grow() {
        int newSize = backingArray.length * 2;
        T[] newStore = (T[]) new Object[newSize];

        for (int i = 0; i < backingArray.length; i++) {
            newStore[i] = backingArray[i];
        }

        backingArray = newStore;
    }
}

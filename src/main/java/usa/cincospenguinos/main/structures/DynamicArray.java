package usa.cincospenguinos.main.structures;

/**
 * Abstraction of a self-growing array. For use to ensure DRYing up pieces of this codebase, but
 * exposed as a valid data structure as well. Intended to be as close to an array as possible.
 */
public class DynamicArray<T> {
    private static final int DEFAULT_STARTING_SIZE = 8;

    private T[] backingArray;

    public DynamicArray() {
        backingArray = (T[]) new Object[DEFAULT_STARTING_SIZE];
    }

    public DynamicArray(int startingSize) {
        backingArray = (T[]) new Object[startingSize];
    }

    /**
     * Insert the item at the index requested. Does not protect against ArrayIndexOutOfBound exceptions.
     *
     * @param item - T item
     * @param index - index to insert item into
     */
    public void insert(T item, int index) {
        backingArray[index] = item;
    }

    public T get(int index) {
        return backingArray[index];
    }

    /**
     * Removes the element at the index provided, returning what was in that spot in the array.
     *
     * @param index to remove an element from
     * @return T item at index
     */
    public T remove(int index) {
        T item = backingArray[index];
        backingArray[index] = null;
        return item;
    }

    public int length() {
        return backingArray.length;
    }

    /**
     * Doubles the array's size.
     */
    public void grow() {
        int newSize = backingArray.length * 2;
        T[] newStore = (T[]) new Object[newSize];

        for (int i = 0; i < backingArray.length; i++) {
            newStore[i] = backingArray[i];
        }

        backingArray = newStore;
    }
}

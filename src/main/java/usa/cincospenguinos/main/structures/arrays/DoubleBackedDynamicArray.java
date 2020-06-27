package usa.cincospenguinos.main.structures.arrays;

public class DoubleBackedDynamicArray<T> implements DynamicArray<T> {
    private static final int DEFAULT_STARTING_SIZE = 8;

    private T[] currentStore;
    private T[] backupStore;

    public DoubleBackedDynamicArray() {
        currentStore = (T[]) new Object[DEFAULT_STARTING_SIZE];
        backupStore = (T[]) new Object[DEFAULT_STARTING_SIZE * 2];
    }

    public DoubleBackedDynamicArray(int startingSize) {
        currentStore = (T[]) new Object[startingSize];
        backupStore = (T[]) new Object[startingSize * 2];
    }

    @Override
    public T get(int index) {
        return currentStore[index];
    }

    @Override
    public void set(T item, int index) {
        currentStore[index] = item;
        backupStore[index] = item;
    }

    @Override
    public T remove(int index) {
        T item = currentStore[index];
        set(null, index);
        return item;
    }

    @Override
    public void grow() {
        currentStore = backupStore;
        backupStore = (T[]) new Object[backupStore.length * 2];
    }

    @Override
    public int length() {
        return currentStore.length;
    }
}

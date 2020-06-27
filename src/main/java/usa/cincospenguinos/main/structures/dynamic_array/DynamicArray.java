package usa.cincospenguinos.main.structures.dynamic_array;

public interface DynamicArray<T> {
    public T get(int index);
    public void set(T item, int index);
    public T remove(int index);
    public void grow();
    public int length();
}

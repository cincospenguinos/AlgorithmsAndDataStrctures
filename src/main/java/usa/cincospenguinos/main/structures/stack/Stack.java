package usa.cincospenguinos.main.structures.stack;

public interface Stack<T> {
    /**
     * Add item to the stack.
     * @param item - T item to add
     */
    public void push(T item);

    /**
     * Return item at top of stack, but do not remove it.
     *
     * @return T item on top of stack
     */
    public T peek();

    /**
     * Remove T item from top of stack and return it.
     *
     * @return T item on top of stack
     */
    public T pop();

    /**
     * Remove all elements from stack
     */
    public void clear();

    public boolean isEmpty();
}

package usa.cincospenguinos.main.structures.stack;

public abstract class AbstractStack<T> {
    /**
     * Add item to the stack.
     * @param item - T item to add
     */
    public abstract void push(T item);

    /**
     * Return item at top of stack, but do not remove it.
     *
     * @return T item on top of stack
     */
    public abstract T peek();

    /**
     * Remove T item from top of stack and return it.
     *
     * @return T item on top of stack
     */
    public abstract T pop();

    /**
     * Remove all elements from stack
     */
    public abstract void clear();

    public abstract boolean isEmpty();
}

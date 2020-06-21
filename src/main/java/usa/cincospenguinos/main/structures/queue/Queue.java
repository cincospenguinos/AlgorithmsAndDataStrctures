package usa.cincospenguinos.main.structures.queue;

public interface Queue<T> {
    /**
     * Add an item to the queue.
     *
     * @param item - T item to enqueue
     */
    public void enqueue(T item);

    /**
     * Remove the first item in the queue.
     *
     * @return T item at the start of the queue
     */
    public T dequeue();
    
    public boolean isEmpty();
}

package usa.cincospenguinos.main.structures.queue;

public class CyclicLinkedQueue<T> implements Queue<T> {
    private Node<T> entryPoint;

    public CyclicLinkedQueue() {
        Node<T> placeholder = new Node<>(null);
        placeholder.next = placeholder;
        entryPoint = placeholder;
    }

    @Override
    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        node.next = entryPoint.next;
        entryPoint.next = node;
        entryPoint = node;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node<T> toRemove = entryPoint.next.next;
        entryPoint.next.next = toRemove.next;
        return toRemove.element;
    }

    @Override
    public boolean isEmpty() {
        return entryPoint == entryPoint.next;
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        Node(T item) {
            element = item;
        }
    }
}

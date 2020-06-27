package usa.cincospenguinos.main.structures.queue;

public class NaiveLinkedQueue<T> implements Queue<T> {
    private Node<T> insertionNode;
    private Node<T> removalNode;

    public NaiveLinkedQueue() {
        insertionNode = null;
        removalNode = null;
    }

    @Override
    public void enqueue(T item) {
        if (insertionNode == null) {
            insertionNode = new Node<>(item);
            removalNode = insertionNode;
        } else {
            Node<T> node = new Node<>(item);
            insertionNode.next = node;
            insertionNode = node;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node<T> nodeToRemove = removalNode;
        removalNode = removalNode.next;
        return nodeToRemove.element;
    }

    @Override
    public boolean isEmpty() {
        return removalNode == null;
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        Node(T item) {
            element = item;
        }
    }
}

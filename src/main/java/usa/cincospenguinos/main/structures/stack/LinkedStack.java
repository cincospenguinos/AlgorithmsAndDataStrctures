package usa.cincospenguinos.main.structures.stack;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> head;
    private int size;

    public LinkedStack() {
        head = new Node<>(null);
        size = 0;
    }

    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.previous = head;
        head = newNode;
        size += 1;
    }

    @Override
    public T peek() {
        return head.item;
    }

    @Override
    public T pop() {
        T item = head.item;

        if (head.previous != null) {
            head = head.previous;
            size -= 1;
        }

        return item;
    }

    @Override
    public void clear() {
        head = new Node<>(null);
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        private T item;
        private Node<T> previous;

        Node(T i) {
            item = i;
        }
    }
}

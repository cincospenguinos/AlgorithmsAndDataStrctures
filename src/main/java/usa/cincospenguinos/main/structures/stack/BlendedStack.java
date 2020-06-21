package usa.cincospenguinos.main.structures.stack;

public class BlendedStack<T> implements Stack<T> {
    private final int DEFAULT_MAX_ARRAY_SIZE = 64;

    private LinkedStack<ArrayStack<T>> backingStore;
    private int maxArraySize;
    private int size;

    public BlendedStack() {
        backingStore = new LinkedStack<>();
        maxArraySize = DEFAULT_MAX_ARRAY_SIZE;
        backingStore.push(new ArrayStack<>(maxArraySize));
        size = 0;
    }

    public BlendedStack(int _maxArraySize) {
        backingStore = new LinkedStack<>();
        maxArraySize = _maxArraySize;
        backingStore.push(new ArrayStack<>(maxArraySize));
        size = 0;
    }

    @Override
    public void push(T item) {
        boolean currentArrayIsFull = size % maxArraySize == 0;
        
        if (!isEmpty() && currentArrayIsFull) {
            ArrayStack<T> newStack = new ArrayStack<>(maxArraySize);
            backingStore.push(newStack);
        }

        ArrayStack<T> array = backingStore.peek();
        array.push(item);
        size += 1;
    }

    @Override
    public T peek() {
        return backingStore.peek().peek();
    }

    @Override
    public T pop() {
        if (backingStore.peek().isEmpty() && size > 0) {
            backingStore.pop();
        }

        T item = backingStore.peek().pop();

        if (size > 0) {
            size -= 1;
        }

        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        backingStore.clear();
        backingStore.push(new ArrayStack<>(maxArraySize));
        size = 0;
    }
}

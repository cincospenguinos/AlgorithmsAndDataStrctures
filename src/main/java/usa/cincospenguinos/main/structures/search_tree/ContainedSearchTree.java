package usa.cincospenguinos.main.structures.search_tree;

public class ContainedSearchTree<K extends Comparable<K>, V> implements SearchTree<K, V> {
    private ContainedSearchTree<K, V> left;
    private ContainedSearchTree<K, V> right;
    private K key;
    private V value;

    public ContainedSearchTree() {}

    private ContainedSearchTree(K _key, V _value) {
        key = _key;
        value = _value;
    }

    @Override
    public V find(K queryKey) {
        if (isEmpty()) {
            return null;
        }

        if (key.equals(queryKey)) {
            return value;
        }

        int comparison = key.compareTo(queryKey);

        if (comparison < 0 && left != null) {
            return left.find(queryKey);
        } else if (comparison > 0 && right != null) {
            return right.find(queryKey);
        }

        return null;
    }

    private boolean isEmpty() {
        return key == null;
    }

    @Override
    public void insert(K insertionKey, V insertionValue) {
        if (key == null) {
            key = insertionKey;
            value = insertionValue;
        }

        int comparisonValue = key.compareTo(insertionKey);

        if (comparisonValue < 0) {
            if (left == null) {
                left = new ContainedSearchTree<>(insertionKey, insertionValue);
            } else {
                left.insert(insertionKey, insertionValue);
            }
        } else if (comparisonValue > 0) {
            if (right == null) {
                right = new ContainedSearchTree<>(insertionKey, insertionValue);
            } else {
                right.insert(insertionKey, insertionValue);
            }
        }
    }

    @Override
    public void delete(K deletionKey) {
        if (key.equals(deletionKey)) {
            key = null;
            value = null;
            return;
        }

        ContainedSearchTree<K, V> parent = this;
        ContainedSearchTree<K, V> current;
        int comparisonValue = key.compareTo(deletionKey);

        if (comparisonValue < 0) {
            current = left;
        } else {
            current = right;
        }

        if (current.key.equals(deletionKey)) {
            current.delete(deletionKey);

            if (current == left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }
}

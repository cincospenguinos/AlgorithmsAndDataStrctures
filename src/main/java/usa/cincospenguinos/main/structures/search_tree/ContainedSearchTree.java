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
        ContainedSearchTree<K, V> parent = null;
        ContainedSearchTree<K, V> current = this;

        while (current != null && !current.key.equals(deletionKey)) {
            parent = current;

            int comparison = current.key.compareTo(deletionKey);

            if (comparison < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return;
        }

        boolean isLeaf = current.isLeaf();
        boolean isRoot = parent == null;

        if (isLeaf) {
            if (isRoot) {
                current.key = null;
                current.value = null;
                return;
            }

            if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }

    private boolean isLeaf() {
        return left == null && right == null;
    }
}

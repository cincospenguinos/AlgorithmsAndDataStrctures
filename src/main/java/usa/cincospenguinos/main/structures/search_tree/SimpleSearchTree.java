package usa.cincospenguinos.main.structures.search_tree;

public class SimpleSearchTree<K extends Comparable<K>, V> implements SearchTree<K, V> {
    private SimpleSearchTree<K, V> left;
    private SimpleSearchTree<K, V> right;
    private K key;
    private V value;

    public SimpleSearchTree() {}

    private SimpleSearchTree(K _key, V _value) {
        key = _key;
        value = _value;
    }

    @Override
    public V find(K queryKey) {
        if (isLeaf()) {
            return key.equals(queryKey) ? value : null;
        }

        if (key == null) {
            return null;
        }

        int comparison = queryKey.compareTo(key);

        if (comparison <= 0) {
            return left.find(queryKey);
        } else if (right != null) {
            return right.find(queryKey);
        }

        return null;
    }

    private boolean isLeaf() {
        return value != null;
    }

    @Override
    public void insert(K insertionKey, V insertionValue)  {
        if (!isLeaf() && left == null) {
            left = new SimpleSearchTree<>(insertionKey, insertionValue);
            key = insertionKey;
        }

        int comparison = insertionKey.compareTo(key);

        if (comparison <= 0) {
            // TODO: Tackle this case
        } else if (right == null) {
            right = new SimpleSearchTree<>(insertionKey, insertionValue);
        }
    }

    @Override
    public void delete(K deletionKey) {

    }
}

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

    private SimpleSearchTree(K _key) {
        key = _key;
    }

    @Override
    public V find(K queryKey) {
        if (isLeaf()) {
            return key.equals(queryKey) ? value : null;
        }

        if (key == null) {
            return null;
        }

        if (comparesLeft(queryKey)) {
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
        if (!isLeaf()) {
            if (left == null) {
                left = new SimpleSearchTree<>(insertionKey, insertionValue);
                key = insertionKey;
                return;
            }
        }

        if (comparesLeft(insertionKey)) {
            if (left.isLeaf() && !insertionKey.equals(left.key)) {
                SimpleSearchTree<K, V> parent = new SimpleSearchTree<>(insertionKey);
                SimpleSearchTree<K, V> leaf = new SimpleSearchTree<>(insertionKey, insertionValue);

                if (left.comparesLeft(insertionKey)) {
                    parent.left = leaf;
                    parent.right = left;
                } else {
                    parent.left = left;
                    parent.right = leaf;
                }

                left = parent;

                return;
            }

            left.insert(insertionKey, insertionValue);
        } else if (right == null) {
            right = new SimpleSearchTree<>(insertionKey, insertionValue);
        }
    }

    private boolean comparesLeft(K otherKey) {
        int comparison = otherKey.compareTo(key);
        return comparison <= 0;
    }

    @Override
    public void delete(K deletionKey) {

    }
}

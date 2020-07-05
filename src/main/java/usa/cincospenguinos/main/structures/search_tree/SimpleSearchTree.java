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
        if (isLeaf() && queryKey.compareTo(key) == 0) {
            return value;
        }

        if (left == null) {
            return null;
        }

        int keyComparison = key.compareTo(queryKey);

        if (keyComparison <= 0) {
            return left.find(queryKey);
        }

        return null;
    }

    private boolean isLeaf() {
        return value != null;
    }

    @Override
    public void insert(K _key, V _value)  {
        if (left == null) {
            left = new SimpleSearchTree<>(_key, _value);
            key = _key;
            return;
        }
    }

    @Override
    public void delete(K key) {

    }
}

package usa.cincospenguinos.main.structures.search_tree;

public interface SearchTree<K extends Comparable<K>, V> {
    public V find(K key);
    public void insert(K key, V value);
    public void delete(K key);
}

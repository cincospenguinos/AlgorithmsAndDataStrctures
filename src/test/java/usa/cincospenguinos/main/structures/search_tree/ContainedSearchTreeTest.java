package usa.cincospenguinos.main.structures.search_tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainedSearchTreeTest {
    @Test
    public void find_returnsNullWhenEmpty() {
        SearchTree<Integer, Integer> tree = new ContainedSearchTree<>();
        assertNull(tree.find(1));
    }

    @Test
    public void insert_worksForOneItem() {
        SearchTree<Integer, Integer> tree = new ContainedSearchTree<>();
        tree.insert(1, 1);
        assertEquals((Integer) 1, tree.find(1));
    }

    @Test
    public void insert_worksForMultipleItems() {
        SearchTree<Integer, Integer> tree = new ContainedSearchTree<>();

        for (int i = 0; i < 10; i++) {
            tree.insert(i, i);
        }

        for (int i = 0; i < 10; i++) {
            Integer value = tree.find(i);
            assertEquals((Integer) i, value);
        }
    }

    @Test
    public void delete_worksForSingleItem() {
        SearchTree<Integer, Integer> tree = new ContainedSearchTree<>();
        tree.insert(1, 1);
        assertEquals((Integer) 1, tree.find(1));

        tree.delete(1);
        assertNull(tree.find(1));
    }

    @Test
    public void delete_worksForRemovingChildNode() {
        SearchTree<Integer, Integer> tree = new ContainedSearchTree<>();
        tree.insert(1, 1);
        tree.insert(2, 2);

        tree.delete(2);
        assertNull(tree.find(2));
        assertNotNull(tree.find(1));
    }
}
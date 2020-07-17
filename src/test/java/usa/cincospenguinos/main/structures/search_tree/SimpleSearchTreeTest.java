package usa.cincospenguinos.main.structures.search_tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSearchTreeTest {
    @Test
    public void find_returnsNullWhenEmpty() {
        SearchTree<Integer, Integer> tree = new SimpleSearchTree<>();
        assertNull(tree.find(1));
    }

    @Test
    public void insert_worksForOneItem() {
        SearchTree<Integer, Integer> tree = new SimpleSearchTree<>();
        tree.insert(1, 1);
        assertEquals((Integer) 1, tree.find(1));
    }

    @Test
    public void insert_worksForRightBranchItems() {
        SearchTree<Integer, Integer> tree = new SimpleSearchTree<>();
        tree.insert(1, 1);
        tree.insert(2, 2);
        assertEquals((Integer) 1, tree.find(1));
        assertEquals((Integer) 2, tree.find(2));
    }

    @Test
    public void insert_worksForMultipleItems() {
        SearchTree<Integer, Integer> tree = new SimpleSearchTree<>();

        for (int i = 0; i < 10; i++) {
            tree.insert(i, i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals((Integer) i, tree.find(i));
        }
    }

    @Test
    public void delete_worksForSingleItem() {
        SearchTree<Integer, Integer> tree = new SimpleSearchTree<>();
        tree.insert(1, 1);
        assertEquals((Integer) 1, tree.find(1));

        tree.delete(1);
        assertNull(tree.find(1));
    }
}
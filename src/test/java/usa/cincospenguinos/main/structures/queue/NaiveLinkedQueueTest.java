package usa.cincospenguinos.main.structures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class NaiveLinkedQueueTest {
    @Test
    public void test_enqueueUpdatesSize() {
        NaiveLinkedQueue<String> queue = new NaiveLinkedQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue("yo");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void test_enqueueHandlesMultipleThings() {
        NaiveLinkedQueue<String> queue = new NaiveLinkedQueue<>();
        queue.enqueue("yo");
        queue.enqueue("yo");
        assertFalse(queue.isEmpty());

        String s = queue.dequeue();
        assertEquals("yo", s);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void test_dequeueReturnsNullWhenEmpty() {
        NaiveLinkedQueue<String> queue = new NaiveLinkedQueue<>();
        assertNull(queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
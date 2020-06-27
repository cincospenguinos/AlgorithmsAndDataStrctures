package usa.cincospenguinos.main.structures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class CyclicLinkedQueueTest {
    @Test
    public void test_enqueueUpdatesSize() {
        CyclicLinkedQueue<String> queue = new CyclicLinkedQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue("yo");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void test_enqueueHandlesMultipleThings() {
        CyclicLinkedQueue<String> queue = new CyclicLinkedQueue<>();
        queue.enqueue("yo");
        queue.enqueue("yo");
        assertFalse(queue.isEmpty());

        String s = queue.dequeue();
        assertEquals("yo", s);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void test_dequeueReturnsNullWhenEmpty() {
        CyclicLinkedQueue<String> queue = new CyclicLinkedQueue<>();
        assertNull(queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
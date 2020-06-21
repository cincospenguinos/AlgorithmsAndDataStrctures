package usa.cincospenguinos.main.structures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {
    @Test
    public void test_enqueueUpdatesSize() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue("hey");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void test_enqueueHandlesWrapping() {
        ArrayQueue<String> queue = new ArrayQueue<>(2);

        for (int i = 0; i < 3; i++) {
            queue.enqueue("hey");
            queue.dequeue();
        }

        assertTrue(queue.isEmpty());
        queue.enqueue("hey");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void test_enqueueGrowsArray() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(2);

        for (int i = 0; i < 3; i++) {
            queue.enqueue(i);
        }

        assertFalse(queue.isEmpty());

        for (int i = 0; i < 3; i++) {
            assertEquals((Integer) i, queue.dequeue());
        }

        assertTrue(queue.isEmpty());
    }

    @Test
    public void test_dequeueUpdatesSize() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("hey");
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test_dequeueReturnsFirstThing() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("hey");
        String s = queue.dequeue();
        assertEquals(s, "hey");
    }

    @Test
    public void test_dequeueReturnsNullWhenEmpty() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        String s = queue.dequeue();
        assertNull(s);
        assertTrue(queue.isEmpty());
    }
}
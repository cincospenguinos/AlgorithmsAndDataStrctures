package usa.cincospenguinos.main.structures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class BlendedStackTest {

    @Test
    public void test_pushUpdatesSize() {
        BlendedStack<String> stack = new BlendedStack<>();
        assertTrue(stack.isEmpty());
        stack.push("hello");

        assertFalse(stack.isEmpty());
    }

    @Test
    public void test_pushHandlesMultiples() {
        BlendedStack<String> stack = new BlendedStack<>(2);
        stack.push("hello");
        stack.push("hello");
        stack.push("hello");

        stack.pop();
        assertFalse(stack.isEmpty());
        assertNotNull(stack.pop());
    }

    @Test
    public void test_peekWorks() {
        BlendedStack<String> stack = new BlendedStack<>();
        stack.push("hello");
        String s = stack.peek();

        assertEquals("hello", s);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void test_peekIsNullWhenEmpty() {
        BlendedStack<String> stack = new BlendedStack<>();
        assertNull(stack.peek());
    }

    @Test
    public void test_popReturnsLastItem() {
        BlendedStack<String> stack = new BlendedStack<>();
        stack.push("hello");
        String s = stack.pop();

        assertEquals("hello", s);
    }

    @Test
    public void test_popReturnsNullWhenEmpty() {
        BlendedStack<String> stack = new BlendedStack<>();
        assertNull(stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void test_clearWorks() {
        BlendedStack<String> stack = new BlendedStack<>();
        stack.push("hey");
        stack.push("hey");
        stack.push("hey");
        stack.clear();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void time_idealArraySizeForAddingTons() {
        int[] sizes = { 2, 4, 8, 16, 32, 64, 128, 256, 512 };

        for (int size : sizes) System.out.print(size + "\t");
        System.out.println("");

        StringBuilder builder = new StringBuilder();
        for (int size : sizes) {
            BlendedStack<Integer> stack = new BlendedStack<>(size);

            long totalTime = 0;
            for (int trial = 1; trial <= 15; trial++) {
                long start = System.nanoTime();
                for (int element = 0; element < 1000000; element++) {
                    stack.push(element);
                }
                long end = System.nanoTime();

                totalTime += (end - start);
            }

            builder.append((totalTime / 10) / 100000);
            builder.append("ms");
            builder.append('\t');
        }

        System.out.println(builder.toString().trim());
    }
}
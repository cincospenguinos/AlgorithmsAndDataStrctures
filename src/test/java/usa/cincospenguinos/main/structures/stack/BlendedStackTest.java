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
    public void clear_works() {
        BlendedStack<String> stack = new BlendedStack<>();
        stack.push("hey");
        stack.push("hey");
        stack.push("hey");
        stack.clear();

        assertTrue(stack.isEmpty());
    }
}
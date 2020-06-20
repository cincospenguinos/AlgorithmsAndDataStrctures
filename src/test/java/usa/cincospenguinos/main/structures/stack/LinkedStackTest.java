package usa.cincospenguinos.main.structures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedStackTest {

    @Test
    public void test_pushUpdatesSize() {
        LinkedStack<String> stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());
        stack.push("hello");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void test_pushAddsMultiples() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("hey");
        stack.push("hello");
        stack.pop();
        assertFalse(stack.isEmpty());
    }

    @Test
    public void test_peekWorks() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("yo");
        String s = stack.peek();

        assertEquals("yo", s);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void test_peekReturnsNullWhenEmpty() {
        LinkedStack<String> stack = new LinkedStack<>();
        assertNull(stack.peek());
    }

    @Test
    public void test_popUpdatesSize() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("hello");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void test_popReturnsItem() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("hello");
        String s = stack.pop();
        assertEquals("hello", s);
    }

    @Test
    public void test_popReturnsNullWhenEmpty() {
        LinkedStack<String> stack = new LinkedStack<>();
        String s = stack.pop();
        assertNull(s);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void test_clearWorks() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("hello");
        stack.push("hello");
        stack.push("hello");
        stack.clear();

        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
    }
}
package usa.cincospenguinos.main.structures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void test_pushUpdatesSize() {
        ArrayStack<String> stack = new ArrayStack<String>();
        assertTrue(stack.isEmpty());
        stack.push("hello");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void test_pushAutomaticallyExtendsArray() {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(1);
        stack.push(1);
        stack.push(2);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void test_peekWorks() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("yo");
        String s = stack.peek();

        assertEquals("yo", s);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void test_peekReturnsNullWhenEmpty() {
        ArrayStack<String> stack = new ArrayStack<>();
        assertNull(stack.peek());
    }

    @Test
    public void test_popUpdatesSize() {
        ArrayStack<String> stack = new ArrayStack<String>();
        stack.push("hello");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void test_popReturnsCorrectThing() {
        ArrayStack<String> stack = new ArrayStack<String>();
        stack.push("hello");
        String s = stack.pop();
        assertEquals("hello", s);
    }

    @Test
    public void test_popReturnsNullOnEmptyStack() {
        ArrayStack<String> stack = new ArrayStack<String>();
        String s = stack.pop();
        assertNull(s);
    }

    @Test
    public void test_clearWorks() {
        ArrayStack<String> stack = new ArrayStack<String>();
        stack.push("yo");
        stack.push("yo");
        stack.push("yo");
        stack.clear();

        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
    }
}
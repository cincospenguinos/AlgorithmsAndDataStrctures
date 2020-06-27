package usa.cincospenguinos.main.structures.dynamic_array;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleBackedDynamicArrayTest {
    @Test
    public void get_returnsNullWithNothingInside() {
        DynamicArray<Integer> array = new DoubleBackedDynamicArray<>(4);
        assertNull(array.get(2));
    }

    @Test
    public void set_works() {
        DynamicArray<Integer> array = new DoubleBackedDynamicArray<>(4);
        array.set(1, 1);
        assertEquals((Integer) 1, array.get(1));
    }

    @Test
    public void remove_works() {
        DynamicArray<Integer> array = new DoubleBackedDynamicArray<>(4);
        array.set(1, 1);

        int value = array.remove(1);
        assertNull(array.get(1));
        assertEquals(1, value);
    }

    @Test
    public void grow_works() {
        DynamicArray<Integer> array = new DoubleBackedDynamicArray<>(1);
        assertEquals(1, array.length());
        array.grow();
        assertTrue(array.length() > 1);
    }
}
package eg.edu.alexu.csd.datastructure.linkedList.cs2cs16;

import org.junit.Test;

import static org.junit.Assert.*;

public class DLinkedListTest {

    @Test
    public void basicResult() {

        DLinkedList test = new DLinkedList();
        test.add(1);
        test.add(3.25);
        test.add(true);
        test.add('t');
        test.add("Try this");

        assertEquals(1, test.get(0));
        assertEquals(3.25, test.get(1));
        assertEquals(true, test.get(2));
        assertEquals('t', test.get(3));
        assertEquals("Try this", test.get(4));

        DLinkedList test2 = test.sublist(1, 3);
        assertEquals(test2.get(0), test.get(1));
        assertEquals(test2.get(1), test.get(2));
        assertEquals(test2.get(2), test.get(3));

        test.add(2, "Middle");
        assertEquals("Middle", test.get(2));

        assertEquals(6, test.size());

        test.remove(2);
        assertEquals(true, test.get(2));

        assertEquals(5, test.size());

        test.set(1, "Fire");
        assertEquals("Fire", test.get(1));
        test.set(4, 25);
        assertEquals(25, test.get(4));

        assertTrue(test.contains(25));
        assertFalse(test.contains(99));

        test.clear();
        assertTrue(test.isEmpty());

        assertEquals(0, test.size());
    }

    @Test
    public void invalidParameter() {

        DLinkedList test = new DLinkedList();
        test.add(1);
        test.add(3.25);
        test.add(true);
        test.add('t');
        test.add("Try this");

        assertNull(test.get(18));
        assertNull(test.get(-1));

        test.set(19, 15);
        test.set(-1, 1.25);
        assertNotEquals(19, test.get(15));
        assertNotEquals(1.25, test.get(-1));

        test.remove(-5);
        test.remove(18);
        assertNotEquals(1, test.get(-5));
        assertNotEquals("Try this", test.get(18));

        DLinkedList test2 = test.sublist(-1, 19);
        assertEquals(1, test2.get(0));
        assertEquals(3.25, test2.get(1));
        assertEquals(true, test2.get(2));
        assertEquals('t', test2.get(3));
        assertEquals("Try this", test2.get(4));
    }

    @Test
    public void nullPointer() {

        DLinkedList test = new DLinkedList();
        test.add(1);
        test.add(3.25);
        test.add(true);
        test.add('t');
        test.add("Try this");

        assertNull(test.get(5));
        assertNull(test.get(-1));
    }
}
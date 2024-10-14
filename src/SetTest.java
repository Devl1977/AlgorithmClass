
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

class SetTest {

    @Test
    void testSetUsingArray() {
        SetInterface<String> arraySet = new SetUsingArray<>();

        assertTrue(arraySet.isEmpty());

        assertTrue(arraySet.add("apple"));

        assertTrue(arraySet.add("banana"));

        // No duplicates allowed
        assertFalse(arraySet.add("apple")); 

        assertTrue(arraySet.contains("apple"));

        assertFalse(arraySet.contains("orange"));

        assertEquals(2, arraySet.getCurrentSize());

        arraySet.remove("apple");

        assertFalse(arraySet.contains("apple"));

        assertEquals(1, arraySet.getCurrentSize());

        arraySet.clear();

        assertTrue(arraySet.isEmpty());
    }

    @Test
    void testLinkedListSet() {
        SetInterface<Integer> linkedListSet = new SetUsingLinkedList<>();

        assertTrue(linkedListSet.isEmpty());
        assertTrue(linkedListSet.add(1));
        assertTrue(linkedListSet.add(2));
        assertFalse(linkedListSet.add(1));  // No duplicates allowed
        assertTrue(linkedListSet.contains(1));
        assertFalse(linkedListSet.contains(3));
        assertEquals(2, linkedListSet.getCurrentSize());

        linkedListSet.remove(1);
        assertFalse(linkedListSet.contains(1));
        assertEquals(1, linkedListSet.getCurrentSize());

        linkedListSet.clear();
        assertTrue(linkedListSet.isEmpty());
    }
}
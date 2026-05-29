import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    private Heap heap = new Heap();

    // add methods

    @Test
    public void testAddSingleElement() {
        heap.add(5);
        assertEquals(1, Heap.heap.size());
        assertEquals(5, (int) Heap.heap.get(0));
    }

    @Test
    public void testAddMaintainsMinHeapOrder() {
        heap.add(10);
        heap.add(3);
        heap.add(7);
        assertEquals(3, (int) Heap.heap.get(0));
    }

    @Test
    public void testAddAlreadyOrdered() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertEquals(1, (int) Heap.heap.get(0));
    }

    @Test
    public void testAddDuplicateElements() {
        heap.add(4);
        heap.add(4);
        heap.add(4);
        assertEquals(3, Heap.heap.size());
        assertEquals(4, (int) Heap.heap.get(0));
    }

    @Test
    public void testAddIncreasesSize() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertEquals(3, Heap.heap.size());
    }
}
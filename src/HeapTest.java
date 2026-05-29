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

    // peak methods

    @Test
    public void testPeakReturnsMinElement() {
        heap.add(10);
        heap.add(3);
        heap.add(7);
        assertEquals(3, Heap.peak());
    }

    @Test
    public void testPeakOnSingleElement() {
        heap.add(42);
        assertEquals(42, Heap.peak());
    }

    @Test
    public void testPeakOnEmptyHeapReturnsNegativeOne() {
        assertEquals(-1, Heap.peak());
    }

    @Test
    public void testPeakDoesNotRemoveElement() {
        heap.add(5);
        heap.add(1);
        Heap.peak();
        assertEquals(2, Heap.getSize());
    }

    @Test
    public void testPeakAfterAddingInOrder() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertEquals(1, Heap.peak());
    }

    @Test
    public void testPeakAfterAddingInReverseOrder() {
        heap.add(9);
        heap.add(6);
        heap.add(3);
        assertEquals(3, Heap.peak());
    }

    @Test
    public void testPeakWithDuplicates() {
        heap.add(2);
        heap.add(2);
        heap.add(2);
        assertEquals(2, Heap.peak());
    }

    // getSize methods

    @Test
    public void testSizeOnEmptyHeap() {
        assertEquals(0, Heap.getSize());
    }

    @Test
    public void testSizeAfterOneAdd() {
        heap.add(1);
        assertEquals(1, Heap.getSize());
    }

    @Test
    public void testSizeAfterMultipleAdds() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertEquals(3, Heap.getSize());
    }

    @Test
    public void testSizeWithDuplicateElements() {
        heap.add(5);
        heap.add(5);
        heap.add(5);
        assertEquals(3, Heap.getSize());
    }

    @Test
    public void testSizeIsNotAffectedByPeak() {
        heap.add(10);
        heap.add(20);
        Heap.peak();
        assertEquals(2, Heap.getSize());
    }
}
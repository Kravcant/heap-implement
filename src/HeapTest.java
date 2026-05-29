import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

public class HeapTest {

    private Heap heap = new Heap();

    // add methods

    @Test
    public void testAddSingleElement() {
        heap.add(5);
        assertEquals(1, heap.getSize());
    }

    @Test
    public void testAddMaintainsMinHeapOrder() {
        heap.add(10);
        heap.add(3);
        heap.add(7);
        assertEquals(3, heap.peak());
    }

    @Test
    public void testAddAlreadyOrdered() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertEquals(1, heap.peak());
    }

    @Test
    public void testAddDuplicateElements() {
        heap.add(4);
        heap.add(4);
        heap.add(4);
        assertEquals(3, heap.getSize());
        assertEquals(4, heap.peak());
    }

    @Test
    public void testAddIncreasesSize() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertEquals(3, heap.getSize());
    }

    // peak methods

    @Test
    public void testPeakReturnsMinElement() {
        heap.add(10);
        heap.add(3);
        heap.add(7);
        assertEquals(3, heap.peak());
    }

    @Test
    public void testPeakOnSingleElement() {
        heap.add(42);
        assertEquals(42, heap.peak());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeakOnEmptyHeapThrows() {
        heap.peak();
    }

    @Test
    public void testPeakDoesNotRemoveElement() {
        heap.add(5);
        heap.add(1);
        heap.peak();
        assertEquals(2, heap.getSize());
    }

    @Test
    public void testPeakAfterAddingInOrder() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertEquals(1, heap.peak());
    }

    @Test
    public void testPeakAfterAddingInReverseOrder() {
        heap.add(9);
        heap.add(6);
        heap.add(3);
        assertEquals(3, heap.peak());
    }

    @Test
    public void testPeakWithDuplicates() {
        heap.add(2);
        heap.add(2);
        heap.add(2);
        assertEquals(2, heap.peak());
    }

    // getSize methods

    @Test
    public void testSizeOnEmptyHeap() {
        assertEquals(0, heap.getSize());
    }

    @Test
    public void testSizeAfterOneAdd() {
        heap.add(1);
        assertEquals(1, heap.getSize());
    }

    @Test
    public void testSizeAfterMultipleAdds() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertEquals(3, heap.getSize());
    }

    @Test
    public void testSizeWithDuplicateElements() {
        heap.add(5);
        heap.add(5);
        heap.add(5);
        assertEquals(3, heap.getSize());
    }

    @Test
    public void testSizeIsNotAffectedByPeak() {
        heap.add(10);
        heap.add(20);
        heap.peak();
        assertEquals(2, heap.getSize());
    }

    // pop method tests

    @Test
    public void testPopReturnsMinElement() {
        heap.add(10);
        heap.add(3);
        heap.add(7);
        assertEquals(3, heap.pop());
    }

    @Test
    public void testPopOnSingleElement() {
        heap.add(42);
        assertEquals(42, heap.pop());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopOnEmptyHeapThrows() {
        heap.pop();
    }

    @Test
    public void testPopRemovesElement() {
        heap.add(5);
        heap.add(1);
        heap.pop();
        assertEquals(1, heap.getSize());
    }

    @Test
    public void testPopRestoresHeapOrder() {
        heap.add(10);
        heap.add(3);
        heap.add(7);
        heap.pop();
        assertEquals(7, heap.peak());
    }

    @Test
    public void testPopSequentiallyReturnsAscendingOrder() {
        heap.add(5);
        heap.add(2);
        heap.add(8);
        heap.add(1);
        assertEquals(1, heap.pop());
        assertEquals(2, heap.pop());
        assertEquals(5, heap.pop());
        assertEquals(8, heap.pop());
    }

    @Test
    public void testPopWithDuplicates() {
        heap.add(3);
        heap.add(3);
        heap.add(3);
        assertEquals(3, heap.pop());
        assertEquals(2, heap.getSize());
    }

    @Test
    public void testPopDecreasesSize() {
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.pop();
        assertEquals(2, heap.getSize());
    }

    @Test
    public void testPopUntilEmpty() {
        heap.add(4);
        heap.add(2);
        heap.pop();
        heap.pop();
        assertEquals(0, heap.getSize());
    }

    @Test
    public void testPopAfterAddingInReverseOrder() {
        heap.add(9);
        heap.add(6);
        heap.add(3);
        assertEquals(3, heap.pop());
        assertEquals(6, heap.pop());
        assertEquals(9, heap.pop());
    }
}
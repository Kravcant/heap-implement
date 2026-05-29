import java.util.ArrayList;
import java.util.List;
/**
 * A min-heap. 
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap  O(log(n))
 * Popping the front of the heap O(log(n))
 * Peeking at the front of the heap without removing the element O(1)
 * Getting the size of the heap O(1)
 * Checking whether the heap is empty O(1)
 * 
 * 
 * The Heap must hold ints
 * 
 * Use List/ArrayList as a backing array, but DO NOT use the 
 * PriorityQueue class. Do not make Node objects, use array
 * indexing instead.
 * 
 * It is up to you to make design decisions about how to:
 *  - name methods
 *  - determine return value and argument types
 *  - hold private instance variables
 */
public class Heap {
    // Instance fields
    public static List<Integer> heap;

    // Heap constructor
    public Heap() {
        heap = new ArrayList<>();
    }

    private static void swap(int a, int b) {
        int index1 = heap.get(a);
        int index2 = heap.get(b);

        heap.set(a, index2);
        heap.set(b, index1);
    }

    public void add(int num) {
        heap.add(num);
        int childIndex = heap.size() - 1;

        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (heap.get(parentIndex) > heap.get(childIndex)) {
                swap(parentIndex, childIndex);
                childIndex = parentIndex; 
            } else break;
        }
    }
}
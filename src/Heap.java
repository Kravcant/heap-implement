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

    /**
     * Helper method that swaps two elements in a heap
     * @param a first element being swapped
     * @param b second element being swapped
     */
    private static void swap(int a, int b) {
        int index1 = heap.get(a);
        int index2 = heap.get(b);

        heap.set(a, index2);
        heap.set(b, index1);
    }

    /**
     * Adds a new element to the end of the heap and bubbles up if necessary
     * @param num new number to add to heap
     */
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
    
    /**
     * Popping the front of the heap O(log(n))
     * @return the integer of the popped element
     */
    public static int pop() {
        if (heap.size() <= 0) return -1;

        // Save the root (minimum value) to return later
        int min = heap.get(0);

        // Overwrite the root with the last element, then remove the last slot
        heap.set(0, heap.getLast());
        heap.removeLast();

        // Bubble down from the root to restore the min-heap property
        int parentIndex = 0;

        while (true) {
            // Calculate the indices of the left and right children
            int leftChild = 2 * parentIndex + 1;
            int rightChild = 2 * parentIndex + 2;

            // Assume the parent is the smallest until proven otherwise
            int smallest = parentIndex;

            // If the left child exists and is smaller, it becomes the candidate to swap
            if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
                smallest = leftChild;
            }

            // If the right child exists and is smaller than the current candidate, it wins
            if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
                smallest = rightChild;
            }

            // If neither child was smaller, the heap property is restored — stop bubbling
            if (smallest == parentIndex) break;

            // Swap the parent down into the smallest child's position and continue from there
            swap(parentIndex, smallest);
            parentIndex = smallest;
        }

        return min;
    }

    /**
     * This method will peak at the first element in the heap, returning the found value.
     * Peeking at the front of the heap without removing the element O(1)
     * @return found integer
     */
    public static int peak() {
        if (heap.size() <= 0) return -1;
        return heap.getFirst();
    }

    /**
     * Getting the size of the heap O(1)
     * @return size of the heap
     */
    public static int getSize() {
        return heap.size();
    }

}
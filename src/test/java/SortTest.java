import org.junit.Test;
import pl.ttpsc.javaupdate.project.Sort;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SortTest {
    @Test
    public void testSmallDataSet() {
        int[] input = {5, 2, 8, 1, 7};
        int[] expected = {1, 2, 5, 7, 8};
        Sort.sortTable(input);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testSmallDataSetSorted() {
        int[] input = {1,2,3,4,5};
        int[] expected = {1,2,3,4,5};
        Sort.sortTable(input);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testSmallDataSetSortedInversely() {
        int[] input = {5,4,3,2,1};
        int[] expected = {1,2,3,4,5};
        Sort.sortTable(input);
         assertArrayEquals(expected, input);
    }
    @Test
    public void testBubbleSortPerformance() {
        int[] array = generateRandomArray(100000);
        long startTime = System.currentTimeMillis();
        Sort.bubbleSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " milliseconds");
        assertTrue(isSorted(array));
    }

    @Test
    public void testArraysSortPerformance() {
        int[] array = generateRandomArray(100000);
        long startTime = System.currentTimeMillis();
        Arrays.sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Arrays.sort (QuickSort) Time: " + (endTime - startTime) + " milliseconds");
        assertTrue(isSorted(array));
    }

    @Test
    public void testParallelSortPerformance() {
        int[] array = generateRandomArray(100000);
        long startTime = System.currentTimeMillis();
        Arrays.parallelSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Arrays.parallelSort Time: " + (endTime - startTime) + " milliseconds");
        assertTrue(isSorted(array));
    }

    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }

    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

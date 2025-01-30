package dsa.arrays_and_strings.two_pointer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class MergeArraysTest {

    private final MergeArrays mergeArrays = new MergeArrays();

    @Test
    void testMergeSortedArraysBasic() {
        int[] arr1 = { 1, 3, 5 };
        int[] arr2 = { 2, 4, 6 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        int[] actual = mergeArrays.mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual, "Basic test case for merging sorted arrays");
    }

    @Test
    void testMergeSortedArraysOneEmpty() {
        int[] arr1 = {};
        int[] arr2 = { 1, 2, 3 };
        int[] expected = { 1, 2, 3 };
        assertArrayEquals(expected, mergeArrays.mergeSortedArrays(arr1, arr2), "Test case where one array is empty");
    }

    @Test
    void testMergeSortedArraysBothEmpty() {
        int[] arr1 = {};
        int[] arr2 = {};
        assertThrows(IllegalArgumentException.class, () -> mergeArrays.mergeSortedArrays(arr1, arr2));
    }

    @Test
    void testMergeSortedArraysWithNegatives() {
        int[] arr1 = { -3, -1, 2 };
        int[] arr2 = { -2, 0, 3 };
        int[] expected = { -3, -2, -1, 0, 2, 3 };
        assertArrayEquals(expected, mergeArrays.mergeSortedArrays(arr1, arr2),
                "Test case with negative and positive numbers");
    }

    @Test
    void testMergeSortedArraysWithDuplicates() {
        int[] arr1 = { 1, 2, 2, 3 };
        int[] arr2 = { 2, 2, 4 };
        int[] expected = { 1, 2, 2, 2, 2, 3, 4 };
        int[] actual = mergeArrays.mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual, "Test case with duplicate elements");
    }

    @Test
    void testMergeSortedArraysWithLargeNumbers() {
        int[] arr1 = { 1000000, 2000000 };
        int[] arr2 = { 1500000, 2500000 };
        int[] expected = { 1000000, 1500000, 2000000, 2500000 };
        assertArrayEquals(expected, mergeArrays.mergeSortedArrays(arr1, arr2), "Test case with large numbers");
    }

    @Test
    void testMergeSortedArraysSingleElements() {
        int[] arr1 = { 1 };
        int[] arr2 = { 2 };
        int[] expected = { 1, 2 };
        assertArrayEquals(expected, mergeArrays.mergeSortedArrays(arr1, arr2),
                "Test case with single elements in each array");
    }

}

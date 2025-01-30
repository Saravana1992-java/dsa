package dsa.arrays_and_strings.two_pointer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ReverseArrayTest {

    ReverseArray reverseArray = new ReverseArray();

    @Test
    void testReverseArrayBasic() {
        int[] nums = { 1, 2, 3, 4, 5 };
        int[] expected = { 5, 4, 3, 2, 1 };
        reverseArray.reverseArray(nums);
        assertArrayEquals(expected, nums, "Basic test case for reversing array");
    }

    @Test
    void testReverseArraySingleElement() {
        int[] nums = { 1 };
        int[] expected = { 1 };
        reverseArray.reverseArray(nums);
        assertArrayEquals(expected, nums, "Test case with a single element");
    }

    @Test
    void testReverseArrayEmptyArray() {
        int[] nums = {};
        assertThrows(IllegalArgumentException.class, () -> reverseArray.reverseArray(nums));
    }

    @Test
    void testReverseArrayEvenLength() {
        int[] nums = { 1, 2, 3, 4 };
        int[] expected = { 4, 3, 2, 1 };
        reverseArray.reverseArray(nums);
        assertArrayEquals(expected, nums, "Test case with an even length array");
    }

    @Test
    void testReverseArrayOddLength() {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int[] expected = { 7, 6, 5, 4, 3, 2, 1 };
        reverseArray.reverseArray(nums);
        assertArrayEquals(expected, nums, "Test case with an odd length array");
    }

    @Test
    void testReverseArrayWithNegatives() {
        int[] nums = { -1, -2, -3, -4, -5 };
        int[] expected = { -5, -4, -3, -2, -1 };
        reverseArray.reverseArray(nums);
        assertArrayEquals(expected, nums, "Test case with negative numbers");
    }

    @Test
    void testReverseArrayWithDuplicates() {
        int[] nums = { 1, 2, 2, 3, 3, 4 };
        int[] expected = { 4, 3, 3, 2, 2, 1 };
        reverseArray.reverseArray(nums);
        assertArrayEquals(expected, nums, "Test case with duplicate elements");
    }

    @Test
    void testReverseArrayWithZeros() {
        int[] nums = { 0, 1, 0, 2, 0, 3 };
        int[] expected = { 3, 0, 2, 0, 1, 0 };
        reverseArray.reverseArray(nums);
        assertArrayEquals(expected, nums, "Test case with zeroes in the array");
    }
}

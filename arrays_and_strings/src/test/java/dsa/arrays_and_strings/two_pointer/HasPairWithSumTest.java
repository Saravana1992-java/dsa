package dsa.arrays_and_strings.two_pointer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HasPairWithSumTest {

    HasPairWithSum twoPointer = new HasPairWithSum();

    @Test
    void testPairExists() {
        int[] nums = { 1, 2, 3, 4, 6 };
        int target = 5;
        assertTrue(twoPointer.hasPairWithSum(nums, target), "Test case where a pair exists");
    }

    @Test
    void testPairDoesNotExist() {
        int[] nums = { 1, 2, 3, 4, 6 };
        int target = 11;
        assertFalse(twoPointer.hasPairWithSum(nums, target), "Test case where no pair exists");
    }

    @Test
    void testWithNegativeNumbers() {
        int[] nums = { -3, -1, 0, 1, 2 };
        int target = -2;
        assertTrue(twoPointer.hasPairWithSum(nums, target), "Test case with negative numbers");
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int target = 5;
        assertThrows(IllegalArgumentException.class, () -> twoPointer.hasPairWithSum(nums, target));
    }

    @Test
    void testSingleElement() {
        int[] nums = { 5 };
        int target = 5;
        assertFalse(twoPointer.hasPairWithSum(nums, target), "Test case with a single element");
    }

    @Test
    void testArrayWithDuplicates() {
        int[] nums = { 1, 2, 2, 3, 4 };
        int target = 4;
        assertTrue(twoPointer.hasPairWithSum(nums, target), "Test case with duplicate elements");
    }

    @Test
    void testLargeNumbers() {
        int[] nums = { 1000000, 2000000, 3000000, 4000000 };
        int target = 5000000;
        assertTrue(twoPointer.hasPairWithSum(nums, target), "Test case with large numbers");
    }

    @Test
    void testNegativeResult() {
        int[] nums = { 1, 2, 3, 4, 5 };
        int target = 0;
        assertFalse(twoPointer.hasPairWithSum(nums, target), "Test case with no possible pair summing to zero");
    }

}

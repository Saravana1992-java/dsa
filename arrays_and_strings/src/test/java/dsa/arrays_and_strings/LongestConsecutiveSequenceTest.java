package dsa.arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LongestConsecutiveSequenceTest {

    private final LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

    @Test
    void testWithMixedNumbers() {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int expected = 4;
        test(nums, expected);
    }

    @Test
    void testWithNegativeNumbers() {
        int[] nums = { 0, -1, 1, 2 };
        int expected = 4;
        test(nums, expected);
    }

    @Test
    void testWithNonConsecutiveNumbers() {
        int[] nums = { 1, 9, 3, 10, 4, 20, 2 };
        int expected = 4;
        test(nums, expected);
    }

    @Test
    void testWithSingleElement() {
        int[] nums = { 5 };
        int expected = 1;
        test(nums, expected);
    }

    @Test
    void testWithEmptyArray() {
        int[] nums = {};
        assertThrows(RuntimeException.class, () -> lcs.findLongestConsecutiveSequence(nums));
    }

    @Test
    void testWithDuplicateElements() {
        int[] nums = { 1, 2, 2, 3, 4 };
        int expected = 4;
        test(nums, expected);
    }

    void test(int[] nums, int expected) {
        assertEquals(expected, lcs.findLongestConsecutiveSequence(nums));
    }
}

package dsa.arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MergeIntervalsTest {

    MergeIntervals m = new MergeIntervals();

    @Test
    void testBasicOverlappingIntervals() {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] expected = { { 1, 6 }, { 8, 10 }, { 15, 18 } };
        test(intervals, expected);
    }

    @Test
    void testNonOverlappingIntervals() {
        int[][] intervals = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int[][] expected = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        test(intervals, expected);
    }

    @Test
    void testCompletelyOverlappingIntervals() {
        int[][] intervals = { { 1, 4 }, { 2, 3 } };
        int[][] expected = { { 1, 4 } };
        test(intervals, expected);
    }

    @Test
    void testSingleInterval() {
        int[][] intervals = { { 1, 5 } };
        int[][] expected = { { 1, 5 } };
        test(intervals, expected);
    }

    @Test
    void testNoIntervalsWithEmptyInput() {
        int[][] intervals = {};
        assertThrows(IllegalArgumentException.class, () -> m.mergeIntervals(intervals));

    }

    @Test
    void testTouchingIntervals() {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int[][] expected = { { 1, 3 }, { 4, 5 } };
        test(intervals, expected);
    }

    @Test
    void testMixedIntervals() {
        int[][] intervals = { { 1, 4 }, { 0, 0 }, { 3, 5 } };
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        System.out.println(Arrays.deepToString(intervals));
        int[][] expected = { { 0, 0 }, { 1, 5 } };
        test(intervals, expected);
    }

    void test(int[][] intervals, int[][] expected) {
        System.out.println("Test Case : " + Arrays.deepToString(m.mergeIntervals(intervals)) + " expected "
                + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(m.mergeIntervals(intervals), expected));
    }

}

package dsa.arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MaxProductSubArrayTest {

    MaxProductSubArray m = new MaxProductSubArray();

    @Test
    void testMaxProductSubArrayWithInvalidInput() {
        assertThrows(RuntimeException.class, () -> m.findMaxProductSubArray(new int[] {}));

    }

    @Test
    void testMaxProductSubArraySinglePositiveNumber() {
        test(new int[] { 5 }, 5);
    }

    @Test
    void testMaxProductSubArrayTC1() {

        test(new int[] { 2, 3, -2, 4 }, 6);

    }

    @Test
    void testMaxProductSubArrayTC2() {

        test(new int[] { -2, 0, -1 }, 0);

    }

    @Test
    void testMaxProductSubArrayTC3() {

        test(new int[] { -2, -3, 8, 9, -4 }, 864);

        // int maxProd = -2;
        // int result = -2;
        // for (int 1=1)
        // maxprod = maxprod * -3;
        // result = max(resut, maxprod)

    }

    @Test
    void testMaxProductSubArrayTC4() {

        test(new int[] { 1, 2, 3, 4 }, 24);

    }

    @Test
    void testMaxProductSubArrayTC5() {
        test(new int[] { 2, 3, -2, 4, -1 }, 48);

        // int maxproduct = i[0];
        // for (int i = 1)
        // maxproduct = maxproduct * 4
    }

    @Test
    void testMaxProductSubArrayTC6() {

        test(new int[] { -1, -3, -10, 0, 60 }, 60);

    }

    @Test
    void testMaxProductSubArrayTC7() {

        test(new int[] { -1, 2, -3, 4, -2 }, 48);
    }

    @Test
    void testMaxProductSubArrayTC8() {

        test(new int[] { -1, 2, -3, 4, -2 }, 48);
    }

    void test(int[] input, int expected) {
        int actual = m.findMaxProductSubArray(input);
        assertEquals(expected, actual);
    }
}

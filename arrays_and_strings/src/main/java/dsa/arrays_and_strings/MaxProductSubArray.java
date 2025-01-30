package dsa.arrays_and_strings;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaxProductSubArray {

    static Logger logger = Logger.getLogger(MaxProductSubArray.class.getName());

    public int findMaxProductSubArray(int[] input) {
        int result = 0;
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Not a valid Input.");
        } else if (input.length == 1) {
            result = input[0];
        } else {
            result = input[0];
            for (int j = 0; j < input.length - 1; j++) {
                int maxProduct = input[j];
                for (int i = j + 1; i < input.length; i++) {
                    maxProduct = maxProduct * input[i];
                    result = Math.max(result, maxProduct);
                }
            }
            Arrays.sort(input);
            result = Math.max(result, input[input.length - 1]);

        }
        logger.log(Level.INFO, "Final result={0}", result);
        return result;
    }

    public int findMaxProductSubArrayOptimized(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Not a valid Input.");
        }

        int maxSoFar = input[0];
        int minSoFar = input[0];
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            int current = input[i];
            if (current < 0) {
                // Swap maxSoFar and minSoFar when current is negative
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }
            maxSoFar = Math.max(current, maxSoFar * current);
            minSoFar = Math.min(current, minSoFar * current);
            result = Math.max(result, maxSoFar);
        }
        logger.log(Level.INFO, "Final result={0}", result);
        return result;
    }
}

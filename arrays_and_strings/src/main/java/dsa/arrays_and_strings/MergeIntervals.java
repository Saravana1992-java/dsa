package dsa.arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeIntervals {

    static Logger logger = Logger.getLogger(MergeIntervals.class.getName());

    public int[][] mergeIntervals(int[][] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Not a valid Input.");
        }
        Arrays.sort(input, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        List<int[]> result = new ArrayList<>();

        int prevStart = input[0][0];
        int prevEnd = input[0][input[0].length - 1];
        int[] interval1 = { prevStart, prevEnd };
        result.add(interval1);
        for (int i = 1; i < input.length; i++) {
            int currentStart = input[i][0];
            int currentEnd = input[i][input[i].length - 1];
            if (prevEnd >= currentStart) {
                // merge
                interval1[1] = Math.max(prevEnd, currentEnd);
            } else {
                interval1 = input[i];
                result.add(interval1);
            }
            prevEnd = currentEnd;
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[][] mergeIntervalsOptimized(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            throw new IllegalArgumentException("Not a valid Input.");
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Initialize the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // There is an overlap, so we merge the intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, so we add the interval to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}

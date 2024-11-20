package dsa.arrays_and_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class LongestConsecutiveSequence {
    static Logger logger = Logger.getLogger(LongestConsecutiveSequence.class.getName());

    public int findLongestConsecutiveSequence(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Not a valid Input.");
        }

        Arrays.sort(input);
        Map<Integer, Set<Integer>> finalResult = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        int prev = input[0];
        int key = 1;
        set1.add(prev);
        finalResult.put(key, set1);

        for (int i = 1; i < input.length; i++) {
            int cur = input[i];
            if (prev == cur)
                continue;
            if (prev + 1 == input[i]) {
                finalResult.get(key).add(cur);
            } else {
                key += 1;
                Set<Integer> set2 = new HashSet<>();
                set2.add(cur);
                finalResult.put(key, set2);
            }
            prev = cur;
        }

        return this.getLongestListItemSize(finalResult);
    }

    public int findLongestConsecutiveSequenceOptimized(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Not a valid Input.");
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : input) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) { // Start of a sequence
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public int getLongestListItemSize(Map<Integer, Set<Integer>> map) {
        int maxSize = 0;
        for (Set<Integer> set : map.values()) {
            if (set.size() > maxSize) {
                maxSize = set.size();
            }
        }
        return maxSize;
    }
}

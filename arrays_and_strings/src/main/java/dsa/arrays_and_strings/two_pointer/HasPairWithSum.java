package dsa.arrays_and_strings.two_pointer;

public class HasPairWithSum {

    public boolean hasPairWithSum(int[] input, int target) {
        boolean result = false;
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Not a valid Input.");
        }

        // 2 pointer
        int left = 0;
        int right = input.length - 1;

        while (left < right) {
            int sum = input[left] + input[right];
            if (sum == target) {
                result = true;
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}

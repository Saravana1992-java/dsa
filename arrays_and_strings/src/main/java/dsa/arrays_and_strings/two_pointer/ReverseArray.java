package dsa.arrays_and_strings.two_pointer;

public class ReverseArray {

    public int[] reverseArray(int[] input) {

        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Not a valid Input.");
        }

        int left = 0;
        int right = input.length - 1;
        while (left < right) {
            int temp = input[right];
            input[right] = input[left];
            input[left] = temp;

            left++;
            right--;
        }

        return input;
    }

}

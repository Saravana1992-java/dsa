package dsa.arrays_and_strings.two_pointer;

public class MergeArrays {

    public int[] mergeSortedArrays(int[] input1, int[] input2) {

        if ((input1 == null || input1.length == 0) && (input2 == null || input2.length == 0)) {
            throw new IllegalArgumentException("Not a valid Input.");
        }

        int left1 = 0;
        int right1 = input1 == null ? 0 : input1.length;

        int left2 = 0;
        int right2 = input2 == null ? 0 : input2.length;

        int[] result = new int[right1 + right2];
        int index = 0;

        while (left1 < right1 && left2 < right2) {
            result[index++] = Math.min(input1[left1++], input2[left2++]);
            result[index++] = Math.max(input1[left1++], input2[left2++]);
            if (input1[left1] == input2[left2]) {
                result[index++] = input1[left1++];
            }
        }

        while (left1 < right1) {
            result[index++] = input1[left1++];
        }

        while (left2 < right2) {
            result[index++] = input2[left2++];
        }

        return result;
    }

}

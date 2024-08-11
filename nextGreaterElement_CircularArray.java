import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementCircularArray {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize the result array with -1
        Stack<Integer> stack = new Stack<>();

        // We go through the array twice to simulate the circular nature
        for (int i = 0; i < 2 * n; i++) {
            // Use modulo to wrap around the array
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 3};
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result)); // Output: [-1, 3, 4]
    }
}

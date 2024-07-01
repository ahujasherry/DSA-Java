//https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE; // maximum sum
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }
}

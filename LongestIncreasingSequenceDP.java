//DP solution

//T.C = O(N)
//S.C = O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxResult = 1;

        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxResult = Math.max(maxResult, dp[i]);
        }
        return maxResult;
    }
}

//https://leetcode.com/problems/house-robber-ii/description/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        //if first house robbed, then skip last 
        //if started from second , then include last
        //take max
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
    
    private int rob(int[] nums, int start, int end){
        int[] numsNew = Arrays.copyOfRange(nums, start, end + 1);
        int[] dp = new int[numsNew.length];
        if(numsNew.length == 0) return 0;
        if(numsNew.length == 1) return numsNew[0];
        dp[0] = numsNew[0];
        dp[1] = Math.max(numsNew[0], numsNew[1]);
        for(int i = 2; i < numsNew.length; i++){
            dp[i] = Math.max(dp[i - 2] + numsNew[i], dp[i - 1]);
        }
        return dp[numsNew.length - 1];
        
    }
}

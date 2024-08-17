class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int n= nums.length;
        int l=0;
        int r=0;
        int sum= 0;
        int ans= Integer.MAX_VALUE;
        int currLen= 0;

        while(r<n)
        {
            sum+= nums[r];
            
            
            //keep shrinking the window and update len
            while(sum>=target)
            {
                ans= Math.min(ans, r-l+1);
                sum-= nums[l];
                l++;                       
            }

            //expand
            r++;

        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
        
    }
}

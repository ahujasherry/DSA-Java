class Solution {
    public boolean canJump(int[] nums) 
    {
        int n = nums.length;
        int max_index = 0;

        for(int i=0;i<n;i++)
        {
            if(max_index < i) return false;
            if(max_index>=n) return true;
            
            max_index = Math.max(max_index,i + nums[i]);

        }
       
       return true;
    }

    
}

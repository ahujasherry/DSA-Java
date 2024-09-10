class Solution {
    public int jump(int[] nums) 
    {
        int n= nums.length;

        int s=0;
        int e =0;
        int jumps=0;
        int max_far = e;

        while(e<n)
        {
            if(max_far < s) break;
            
            if(max_far >= n-1) break;

            //check how far we can go
            for(int i=s;i<=e;i++)
            {
                max_far = Math.max(max_far, nums[i]+i );
            }

            s = e+1;
            e = max_far;
            jumps++;
        }

        if(max_far >= n-1) return jumps;
        else return -1;
        
    }

    
}

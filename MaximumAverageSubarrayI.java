class Solution {
    public double findMaxAverage(int[] nums, int k)
    {
        int n = nums.length;
        int sum =0;
        int maxSum=0;
        int i=0;
        for(i=0;i<k;i++)
        {
            sum+= nums[i];
        }
        
        maxSum = sum;

        for(i = k;i<n;i++)
        {
            
            //add kth and remove start element
            sum+= nums[i] - nums[i-k];
            maxSum = Math.max(maxSum,sum);
           
        }

        return (double)maxSum/k;
    }
}

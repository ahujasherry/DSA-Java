//https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public int[] productExceptSelf(int[] nums) {
         int n = nums.length;
        int prefix[]= new int[n];   //stores prefix product except ith element
        int suffix[]= new int[n];   //stores prefix product except ith element
        int result[]= new int[n];   //stores product except itself


        prefix[0]=1;
        suffix[n-1]=1;

        for (int i = 1; i <n ; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for (int i = n-2; i >=0 ; i--) {
            suffix[i] = suffix[i+1] *nums[i+1];
        }

        for (int i = 0; i <n ; i++) {
            result[i] = prefix[i] * suffix[i];
        }        
        
        return  result;
    }
}

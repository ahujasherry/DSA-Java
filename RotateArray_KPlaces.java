//https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public void rotate(int[] nums, int k)
     {
         /*
            T.C = O(n) S.C = O(n)
            int n = nums.length;
            int res[] = new int[n];

            k = k%n;

            for (int i = 0; i < n; i++) {
                res[(i+k)%n] = nums[i];
            }

            System.arraycopy(res,0,nums,0,n);

         */

        //T.C = O(n) S.C = O(1)

        int n= nums.length;
        k = k%n;

        reverseArray(nums,0,n-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,n-1);
    }

    private static void reverseArray(int[] nums,int start, int end)
    {

        while(start<end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]= temp;
            start++;
            end--;
        }
    }
}

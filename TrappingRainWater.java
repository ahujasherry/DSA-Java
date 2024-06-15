//https://leetcode.com/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    //S.C = O(1)
    //T.C = O(n)
    public  int trap(int[] height)
    {
       int trap = 0;
        int n  = height.length;
        int leftMax=0;
        int rightMax=0;
        int left = 0;
        int right = n-1;

        while(left<=right)
        {
            if(height[left] <= height[right])
            {
                if(height[left]>= leftMax){
                    leftMax = height[left];
                }else {
                    trap+= leftMax - height[left];
                }

                left++;

            }else {

                if(height[right]>= rightMax){
                    rightMax = height[right];
                }else{
                    trap+= rightMax - height[right];
                }
                right--;
            }



        }

        return  trap;
    }
}

//https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majourityEle = -1;
        int count = 0;

        for (int i = 0; i <n ; i++)
        {
            if(count<=0)
            {
                majourityEle = nums[i];
                count=1;
            }

            else if(majourityEle == nums[i])
            {
                count++;
            }else{
                count--;
            }

            

        }
        return majourityEle;
    }
}

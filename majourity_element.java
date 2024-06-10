//https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majourityEle = nums[0];
        int count = 1;

        for (int i = 1; i <n ; i++)
        {
            if(majourityEle == nums[i])
            {
                count++;
            }else{
                count--;
            }

            if(count<=0){
                majourityEle = nums[i];
                count=1;
            }

        }
        return majourityEle;
    }
}

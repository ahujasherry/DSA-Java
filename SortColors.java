//https://leetcode.com/problems/sort-colors/description/
// T.C = O(N)
// S.C = O(1)
class Solution {
    public void sortColors(int[] nums) {
        //from 0 - low -> 0's
        //from low - mid -> 1's
        // from mid - high -> unknown
        // from high to n-1 -> 2's
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}

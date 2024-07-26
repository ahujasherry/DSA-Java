//https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
    public int singleNonDuplicate(int[] arr) 
    {
        int n = arr.length; 
        int ans = 0;
        // XOR all the elements:
        for (int i = 0; i < n; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
        
    }
}

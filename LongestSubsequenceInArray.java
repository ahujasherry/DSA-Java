//https://leetcode.com/problems/longest-consecutive-sequence/
// T.C = O(N)  + O(2N)
// S.C = O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : nums) 
        {
            //if start of subsequence, calculate length
            if (!numSet.contains(num - 1)) 
            {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;        
    }
}

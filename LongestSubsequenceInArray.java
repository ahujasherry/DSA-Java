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

    //Fast 
    public static int longestConsecutive1(int nums[]) {
        int n = nums.length;
        if (n == 0) // edge case
            return 0;

        Arrays.sort(nums);

        int count = 1, maxi = 1;
        for (int i = 0; i < n - 1; i++) 
        {
            if (nums[i] == nums[i + 1])
                continue; // ignoring duplicates
            if (nums[i]+1 == nums[i+1]) 
            {
                count++; // checking consecutive elements
            } else
            {
                maxi = Math.max(maxi, count); // storing maximum length of the sequence
                count = 1;
            }
        }
        maxi = Math.max(maxi, count);
        return maxi;

    }
}

//https://leetcode.com/problems/subsets-ii/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> uniqueSet = new ArrayList<>();
        List<Integer> currSubset = new ArrayList<>();
        f(0, nums.length, nums, currSubset, uniqueSet);
        return uniqueSet;
    }

    public static void f(int i, int n, int nums[], List<Integer> currSubset, List<List<Integer>> uniqueSet) {
        if (i >= n) {
            uniqueSet.add(new ArrayList<>(currSubset));
            return;
        }

        //add current to subset
        currSubset.add(nums[i]);
        f(i + 1, n, nums, currSubset, uniqueSet);
        
        //backtrack
        currSubset.remove(currSubset.size() - 1);

        //now when not picking ith, skip the duplicates too
        while(i<n-1 && nums[i]==nums[i+1]) i++;

        f(i + 1, n, nums, currSubset, uniqueSet);
    }
}

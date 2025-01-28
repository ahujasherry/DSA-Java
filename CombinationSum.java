

//https://leetcode.com/problems/combination-sum/
class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);

        backtrack(list, new ArrayList<>(), arr, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> ds, int[] arr, int target, int ind)
    {

        if (ind == arr.length)
        {
            if (target == 0) {
                res.add(new ArrayList < > (ds));
            }
            return;
        }
        
        if (arr[ind] <= target) 
        {
            ds.add(arr[ind]);
            backtrack(res,ds, arr, target - arr[ind], ind);
            ds.remove(ds.size() - 1);
        }
        backtrack(res, ds, arr, target, ind + 1);

    }
}

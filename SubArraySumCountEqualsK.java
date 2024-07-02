//https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) 
    {
        int sum=0,count=0;

        // <sum,frequency>
        Map<Integer,Integer> preSumMap=new HashMap<>();

        preSumMap.put(0,1);

        for(int i=0; i<nums.length;i++)
        {
            sum+=nums[i];

            if(preSumMap.containsKey(sum-k))
            {

                count+=preSumMap.get(sum-k);
            }

            //increase the freq of sum if alredy present
            preSumMap.put(sum,preSumMap.getOrDefault(sum,0)+1);
        }

        return count;
        
    }
}

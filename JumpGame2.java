//T.C = O(N)
//S.C = O(1)
class Solution {
    public int jump(int[] arr)
    {

        int ans =0;
        int n =arr.length;
        int start=0;
        int end =0;

        while(end<n-1)
        {
            //try every max jump within this range

            int farthest_index =0;
            for(int i = start;i<=end;i++)
            {
                farthest_index = Math.max(farthest_index, i + arr[i]);
            }

            //since, we know know maximum jump we can take in that range
            //update the range

            start = end+1;
            end = farthest_index;
            ans++;

        }

        return ans;
        
    }
}

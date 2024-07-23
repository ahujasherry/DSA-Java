//T.C = O(N)
//S.C = O(1)
class Solution {
    public int jump(int[] arr) 
    {
        int jumps=0;
        int l =0;
        int r=0;
        int n = arr.length;
      

        while(r<n-1)
        {
            int far  = 0;
            for(int i=l;i<=r;i++)
            {
                far = Math.max(far, i+arr[i]);
            }

            //update next values
            jumps++;
            l = r+1;
            r = far;
        }

        return jumps;
        
    }
}

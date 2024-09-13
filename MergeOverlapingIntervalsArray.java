
class Solution {
    public int[][] merge(int[][] intervals) 
    {
        int n = intervals.length;
        
        if(n==0 ) return new int[0][0];

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        List<int[]> ans = new ArrayList<>();

        int prevInterval[]= intervals[0];
        ans.add(prevInterval);

        for(int i=1;i<n;i++)
        {
            int currentInterval[]  = intervals[i]; 

            //if merge
            if(prevInterval[1] >= currentInterval[0] ) 
            {
               
                //update end in ans list as ref 
                prevInterval[1] = Math.max(currentInterval[1],prevInterval[1]);
            }else
            {

                prevInterval = currentInterval;
                ans.add(prevInterval);
            }
        }

        return ans.toArray(new int[ans.size()][]);

       
        
    }
}

//https://leetcode.com/problems/insert-interval/description/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        int m = intervals.length;
        List<int[]> res = new ArrayList<>();
        
        int i=0;
        //find starting non overlapping
        //if interval end < new interval start
        while(i<m && intervals[i][1] < newInterval[0] )
        {
            res.add(intervals[i]);
            i++;

        }

        //merge overlappnig
        while(i<m && intervals[i][0]<= newInterval[1])
        {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0] );
            newInterval[1] = Math.max(newInterval[1],intervals[i][1] );
            i++;
        }

       res.add(newInterval);

        //add rest
        while(i<m)
        {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
        
    }
}

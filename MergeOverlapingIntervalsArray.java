//https://leetcode.com/problems/merge-intervals/
class ResPair{
    int start ;
    int end ;

    public ResPair() {
    }

    public ResPair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) 
    {
         int n = intervals.length;
        int k =0;
        int i =1;
        int finalRes [][]= new int[n][2];

        Arrays.sort(intervals, Comparator.comparingInt(l -> l[0]));


        List<ResPair> resList = new ArrayList<>();
        resList.add(new ResPair(intervals[0][0],intervals[0][1]));

        while(i<n)
        {
             ResPair prev = resList.get(k);

             //if merge
             if(prev.end >= intervals[i][0])
             {
                 //update end in result
                 prev.end = Math.max(prev.end, intervals[i][1]);
                 prev.start = Math.min(prev.start, intervals[i][0]);
                 resList.set(k, prev);
             }else {
                 k++;
                 //add new pair
                 resList.add(new ResPair(intervals[i][0],intervals[i][1]));
             }

             i++;
        }

      finalRes =resList.stream().map(resPair -> new int[]{resPair.start, resPair.end})
               .toArray(int[][]::new);

        return finalRes;
        
    }
}

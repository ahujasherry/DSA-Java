class Solution {
    public int findContentChildren(int[] g, int[] s) 
    {
        int i=0;
        int j=0;
        int m = g.length;
        int n = s.length;
        
        //assign cookie to children who are less greedy first
        Arrays.sort(g);
        Arrays.sort(s);
    
        while(i<m && j<n)
        {
            //if cookie assigned 
            if(g[i]<=s[j])
            {
                i++;
                j++;
            }else{
                j++;
            }
        }
        
       return i;
    }

    
}

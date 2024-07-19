class Solution {
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        boolean dp[]= new boolean[s.length()+1];
        dp[0]= true;
        
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        //calculate for every len
        for (int i = 1; i <= s.length(); i++) 
        {
            //check for each substring for length
            for(int j=i-1;j>=0;j--)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
           
        }

        return dp[s.length()];
    }

    
}

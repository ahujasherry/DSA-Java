class Solution {
    public int characterReplacement(String str, int k) 
    {
        int maxFreq=0;
        int n = str.length();
        int ans =0;


        //generate all substring
        for(int i=0;i<n;i++)
        {
            int freq[]=new int[26];
        
            for(int j=i;i<n;j++)
            {
                
                //increase freq
                freq[str.charAt(j)-'A']++;

                //keep track of max freq
                maxFreq = Math.max(maxFreq, freq[str.charAt(j)-'A']);

                int sublen = j-i+1;
                int replacementsCanbeDone = sublen - maxFreq;

                if(replacementsCanbeDone <= k)
                {
                    ans = Math.max(ans,replacementsCanbeDone );
                }else
                {
                    break;
                }

            }
        }
        return ans;
    }
}

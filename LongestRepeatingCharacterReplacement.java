class Solution {
    public int characterReplacement(String str, int k) 
    {
        int maxFreq=0;
        int n = str.length();
        int ans =0;
        int s = 0;
        int e=0;
        int freq[]=new int[26];

        while(e<n)
        {
            //increase freq
            freq[str.charAt(e)-'A']++;

            //keep track of max freq because subLen - maxFreq replacements can be done
            maxFreq = Math.max(maxFreq, freq[str.charAt(e)-'A']);

            
            // keep trimming window if required replacements are > k
            // no need to update maxFreq when decreased because one char is added and one removed at a time
            if( (e - s + 1) - maxFreq > k)
            {
                freq[str.charAt(s) - 'A']--;
                s++;
            }

            ans = Math.max(ans,e-s+1);
            e++;


        }
        return ans;
    }
}

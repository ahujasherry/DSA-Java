
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        
        int n = s.length();
        if(n==0) return 0;

        //character, lastSeenIndex
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;


        int l = 0;
        int r = 0;

        while(r<n)
        {
            char  c = s.charAt(r);
          
            if(map.containsKey(c))
            {
                Integer lastIndex = map.get(c);
                //if within current [l,r] window, update l
                if(lastIndex>= l)
                {
                    l = lastIndex + 1;
                }

            }
        
            map.put(c, r);
            len = Math.max(len, r-l+1);  
            r++;
        }
        return len;
        
    }
}

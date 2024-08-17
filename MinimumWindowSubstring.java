class Solution {
    public String minWindow(String s, String t) 
    {
        int m = s.length();
        int n = t.length();
         if (m == 0 || n == 0 || m < n) {
            return "";
        }

        //char , freq
        int map[]=new int[256];
        int count = 0;
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;

        
        for (char c : t.toCharArray()) {
            map[c]++;    
        }


        while(end < m)
        {
            //if character in s has freq >0, it is coming from t
            //we need to count it
            char endChar = s.charAt(end);
            if(map[endChar] >0)
            {
                
                count++;
            }

            // expand the window always
            //and keep decreasing endChar freq
            map[endChar]--;
            end++;

            //now when count becomes equal to t length
            //means we got our window
            //save and keep shrinking 
            while(count ==n)
            {
                //update min length ans
                //and keep start index of that window
                if(end-start < minLen)
                {
                    minLen = end-start;
                    startIndex = start;
                }
                
                //if freq is 0, means it was coming from t, 
                //decrease count
                char startChar = s.charAt(start);
                if(map[startChar]==0)
                {
                    count--;    
                }
                
                //restore freq as we remove char from start
                map[startChar]++;
                start++;
            }    


        }

        return minLen == Integer.MAX_VALUE ? new String() : 
                            s.substring(startIndex,startIndex + minLen);
       
        
    }
}

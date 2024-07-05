class Solution {
    public String longestCommonPrefix(String[] str) 
    {
       StringBuilder sb  = new StringBuilder();
        int min_len = Integer.MAX_VALUE;
        int m = str.length;
        boolean finish =false;
        for(int i=0;i<m;i++)
        {
            min_len = Math.min(min_len, str[i].length());
        }
        

        int j=0;
        char arr[][]=new char[m][min_len];
        for(int i=0;i<m;i++)
        {
            arr[i] = str[i].toCharArray();
        }
        
      
    
        //compare
        while(j<min_len)
        {
            for(int i=1;i<m;i++)
            {
                if(arr[i][j]!=arr[i-1][j])
                {
                    finish  = true;
                    break;
                }
            }
            if(!finish)
            {
                  sb.append(arr[0][j]);
                j++;
            }else{
                break;
                
            }
          
        }

        
        return sb.toString();
        
    }
}

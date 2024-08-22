class Solution {
    public String mergeAlternately(String s1, String s2) 
    {
        int m = s1.length();
        int n = s2.length();
        StringBuilder sb = new StringBuilder();

        int i=0;
        int j=0;
        boolean flag = true;

        while(i<m && j<n)
        {
            sb.append(s1.charAt(i++));
            sb.append(s2.charAt(j++));
               
        }

        while(i<m)
        {
            sb.append(s1.charAt(i++));
        }

         while(j<n)
        {
            sb.append(s2.charAt(j++));
        }
        
        return sb.toString();
    }
}

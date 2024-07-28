//https://leetcode.com/problems/reverse-words-in-a-string/
class Solution {
    public String reverseWords(String s) 
    {
        int n = s.length();
        int i= n-1;
        StringBuilder sb = new StringBuilder();

        while(i>=0)
        {
            //cut trailing spaces
            while(i>=0 && s.charAt(i)==' ')i--;

            //no more words to process
            if(i<0) break;

            int j=i-1;

            while(j>=0 && s.charAt(j)!=' ')j--;

            sb.append(s.substring(j+1,i+1)).append(" ");;
           

            i = j;
            
        }
        
       return (sb.length()>0)? sb.deleteCharAt(sb.length()-1).toString():sb.toString();
    }
}

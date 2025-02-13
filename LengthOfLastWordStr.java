class Solution {
    public int lengthOfLastWord(String s) 
    {
       int n =s.length();
       int count=0;

        int i=n-1;
        while(s.charAt(i)==' ')
        {
            i--;
        }

        while(i>=0 && s.charAt(i--)!=' ')
        {
            count++;
        }
       

        return count;
    }
}

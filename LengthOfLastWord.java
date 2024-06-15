//https://leetcode.com/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public int lengthOfLastWord(String s) {
         int len = 0;
        
        for (int i =s.length()-1; i >=0 ; i--)
        {
            if(s.charAt(i)!=' '){
                len++;
            }else if(len>0){
                break;
            }

        }
        return len;
    }
}

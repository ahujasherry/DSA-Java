//Leetcode link : https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
//2 pointers approach
// T.C = O(n) where n is len(t) or len(s) whichever is longer
// S.C = O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s.length()==0)
            return true;

        boolean result = false;
        int k = 0;

        for (int i = 0; i < t.length(); i++)
        {
            if(s.charAt(k)==t.charAt(i)){
                k++;
            }

            if(k>=s.length()){
                result = true;
                break;
            }

        }

        return  result;
    }
}

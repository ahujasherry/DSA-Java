//https://leetcode.com/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
//not the optimal solution
//using library methods
class Solution {
    public int lengthOfLastWord(String s) {
        String sub[]= s.stripLeading().stripTrailing().split(" ");
        return sub[sub.length-1].length();
    }
}

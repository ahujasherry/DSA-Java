//https://leetcode.com/problems/edit-distance/
class Solution {
    public int minDistance(String word1, String word2) {
         int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return minDistanceUtil(word1,word2,word1.length()-1,word2.length()-1,dp);
    }

    //recursion + memoization
    private static int minDistanceUtil(String S1, String S2, int i, int j,int[][] dp)
    {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        // If the result is already computed, return it
        if (dp[i][j] != -1)
            return dp[i][j];

        // If the characters at the current positions match, no edit is needed
        if (S1.charAt(i) == S2.charAt(j))
            return dp[i][j] = minDistanceUtil(S1, S2, i - 1, j - 1, dp);

            // Minimum of three choices:
            // 1. Replace the character in S1 with the character in S2.
            // 2. Delete the character in S1.
            // 3. Insert the character from S2 into S1.
        else
            return dp[i][j] = 1 + Math.min(minDistanceUtil(S1, S2, i - 1, j - 1, dp),
                    Math.min(minDistanceUtil(S1, S2, i - 1, j, dp), minDistanceUtil(S1, S2, i, j - 1, dp)));
    }
}

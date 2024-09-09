import java.io.*;
//https://www.geeksforgeeks.org/find-length-longest-subsequence-one-string-substring-another-string/
class Result {

    // Helper function to check if `s` is a subsequence of `x`
    public static boolean isSubsequence(String x, String s) {
        int m = x.length();
        int n = s.length();
        int j = 0; // Pointer for s
        
        for (int i = 0; i < m && j < n; i++) {
            if (x.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        
        return j == n;
    }

    // Function to find the longest subsequence in x which is also a substring in y
    public static int longestSubsequence(String x, String y) {
        int maxLength = 0;
        int n = y.length();
        
        // Check all possible substrings of y
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                String substring = y.substring(start, end);
                
                // Check if this substring is a subsequence of x
                if (isSubsequence(x, substring)) {
                    maxLength = Math.max(maxLength, substring.length());
                }
            }
        }
        
        return maxLength;
    }

}

}

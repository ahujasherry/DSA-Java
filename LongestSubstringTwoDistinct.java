import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoDistinct {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) {
            return n;
        }

        // Map to store the frequency of characters in the current window
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0; // Left pointer of the sliding window
        int maxLen = 2; // Initialize the maximum length

        for (int right = 0; right < n; right++) {
            // Add the current character to the map
            char currentChar = s.charAt(right);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

            // If the map contains more than 2 distinct characters, shrink the window
            while (charCount.size() > 2) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++; // Move the left pointer to the right
            }

            // Update the maximum length of the window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s)); // Output: 3
    }
}

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String ans = countAndSay(n - 1);
        StringBuilder finalAns = new StringBuilder();

        int i = 0;
        while (i < ans.length())
        {
            int count = 1;
            while (i + 1 < ans.length() && ans.charAt(i) == ans.charAt(i + 1)) {
                count++;
                i++;
            }

            // Append count and the character
            finalAns.append(count);
            finalAns.append(ans.charAt(i));

            // Move to the next distinct character
            i++;
        }

        return finalAns.toString();
    }
}

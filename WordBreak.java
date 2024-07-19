class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreakUtil(s, wordSet, memo);

    }

    public boolean wordBreakUtil(String s, Set<String> wordSet, Map<String, Boolean> memo) {

        if (memo.containsKey(s)) {
            return memo.get(s); 
        }

        if(wordSet.contains(s)){
            memo.put(s,true);
            return true;
        }

        for (int i = 1; i < s.length(); i++) 
        {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix) &&
                    wordBreakUtil(s.substring(i), wordSet,memo))
            {
                memo.put(s,true);
                return true;
            }
        }

        memo.put(s, false);
        return false;

    }
}

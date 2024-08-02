
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            char charArray[] = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if(!map.containsKey(sortedStr))
            {
                map.put(sortedStr, new ArrayList<>());
            }
            
            map.get(sortedStr).add(strs[i]);
            
        }
        
        // for(Map.Entry<String, List<String>> entry: map.entrySet())
        // {
        //     ans.add(new ArrayList<>(entry.getValue()));
        // }
        return new ArrayList<>(map.values());

    }
}

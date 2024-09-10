import java.util.*;

class Solution {
    public String reorganizeString(String s) 
    {
        
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
        new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());

        //build freq map
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        maxHeap.addAll(map.entrySet());

        StringBuilder ans = new StringBuilder();

        while(maxHeap.size() >1)
        {
            //get top 2 elements 
            Map.Entry<Character, Integer> first = maxHeap.poll();
            Map.Entry<Character, Integer> second = maxHeap.poll();

            ans.append(first.getKey());
            ans.append(second.getKey());

            //decrease freq if >1 and add back in maxHeap
            if(first.getValue()>1)
            {
            maxHeap.add(new AbstractMap.SimpleEntry<>(first.getKey(),first.getValue()-1));
            }
            if(second.getValue()>1)
            {
            maxHeap.add(new AbstractMap.SimpleEntry<>(second.getKey(),second.getValue()-1));
            }

        }      

        if (!maxHeap.isEmpty()) 
        {
            Map.Entry<Character, Integer> lastEntry = maxHeap.poll();

            //if freq is >1, return false
            if (lastEntry.getValue() > 1) return "";


            ans.append(lastEntry.getKey());
        }  

        return ans.toString();
        
    }
}

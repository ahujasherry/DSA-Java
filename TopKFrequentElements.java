//https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        
        List<Integer> bucket[] = new ArrayList[nums.length+1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        
        //build freq map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            int freq = entry.getValue();
            int value = entry.getKey();
            bucket[freq].add(value);
        }

        int bucketSize = bucket.length;
        int countAndIndex =0;
        int result[]=new int[k];

        for(int i= bucketSize -1 ;i>=0;i--)
        {
            for(int j=0; j< bucket[i].size();j++)
            {
                if(countAndIndex<k)
                {
                    result[countAndIndex++]= bucket[i].get(j);
                }

            }

        }

            return result;

       
    }

    //t.c= O(nlogk)
    public int[] topKFrequentPriorityQueue(int[] nums, int k)
    {
       PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return Integer.compare(a.freq, b.freq);
            }
        });


        HashMap<Integer,Integer> map  = new HashMap<>();
        int res[]= new int[k];

        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
        {
            queue.offer(new Pair(entry.getKey(), entry.getValue()));
            if (queue.size() > k) {
                queue.poll();
            }
        }

        for(int i=0;i<k;i++)
        {
            res[i] = queue.poll().val;
        }

        return res;


        
    }
}

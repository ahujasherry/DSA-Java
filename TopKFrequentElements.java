//https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (int key : hm.keySet()) {
            int freq = hm.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] ans = new int[k];
        int pos = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && pos < k; j++) {
                    ans[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }
        return ans;

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

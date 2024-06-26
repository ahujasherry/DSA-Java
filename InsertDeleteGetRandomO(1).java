//https://leetcode.com/problems/insert-delete-getrandom-o1/?envType=study-plan-v2&envId=top-interview-150
class RandomizedSet {

    Map<Integer,Integer> map ;
    List<Integer> list ;


    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    //T.C = O(1)
    public boolean insert(int val)
    {
        if(map.containsKey(val)) return false;

        map.put(val,list.size());
        list.add(val);
        return true;

    }

    //T.C = O(1)
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int index = map.get(val);                  //get index from map
        map.put(list.get(list.size()-1), index);   //replace last element of list to index place in both map and list
        list.set(index,list.get(list.size()-1));

        map.remove(val);                   // remove from map
        list.remove(list.size()-1);        //remove from list
        return true;

    }

    //T.C = O(1)
    public int getRandom() {
       return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

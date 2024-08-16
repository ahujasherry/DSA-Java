import java.util.*;

class HeapComparator implements Comparator<Map.Entry<String,Integer>>
    {
         @Override
         public int compare(Map.Entry<String,Integer> entry1,Map.Entry<String,Integer> entry2)
           {
               //if values are same, sort based on key ( "ABC","DEF")
               if(entry1.getValue().equals(entry2.getValue()))
               {
                   return entry1.getKey().compareTo(entry2.getKey());
               }
               
               //asc order of value
               //[2,2,3]
               return Integer.compare(entry1.getValue(),entry2.getValue());
           }
    }
    
public class HelloWorld {
    public static void main(String[] args)
    {
        
        HashMap<String,Integer> map= new HashMap<>();
       map.put("ABC",1); 
        map.put("DEF",2); 
       map.put("XYZ",3);
       
       sortMap(map);
        
    }
    
     
    
    
    static void sortMap(HashMap<String,Integer> hashMap)
    {
        
        // K, V
        List<Map.Entry<String,Integer>> list =new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new HeapComparator());
        
    
        //printing the tree map
        for(Map.Entry<String,Integer> entry:list)
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        
    }
}
